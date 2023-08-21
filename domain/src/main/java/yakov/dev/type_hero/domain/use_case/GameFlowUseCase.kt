package yakov.dev.type_hero.domain.use_case

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import yakov.dev.type_hero.domain.entity.GamePhase
import yakov.dev.type_hero.domain.entity.GameState
import yakov.dev.type_hero.domain.entity.TypeState
import yakov.dev.type_hero.domain.repository.StatsRepository
import java.util.Timer
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * Currently responsible for timer and game-time stats (not SOLID)
 * TODO("Refactor UseCases")
 */
class GameFlowUseCase @Inject constructor(
    private val statsRepository: StatsRepository
) {

    private val _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()

    fun onWordFinish(isCorrect : Boolean) {
        statsRepository.onWordFinish(isCorrect)

        _gameState.update {
            val correct = if (isCorrect) it.correct + 1 else it.correct
            val wrong = if (!isCorrect) it.wrong + 1 else it.wrong
            val accuracy : Float = correct / (correct + wrong).toFloat()
            it.copy(
                correct = correct,
                wrong = wrong,
                accuracy = accuracy
            )
        }
        changeStatWordsPerMinute()
    }

    fun onCharInput(input : String, typeState: TypeState) {
        val char = input.lastOrNull() ?: error("Empty strings not allowed here")
        try {
            // If last char of our input is equal to same position char in gameWords, we are correct
            val isCorrect = typeState.run { char == gameWords[currentInputWordIndex][input.lastIndex] }
            statsRepository.onCharInput(char = char, isCorrect = isCorrect)
        } catch (e : StringIndexOutOfBoundsException) {
            // If the player types more chars than there are in the current word
        }
        manageTimer(typeState)
    }

    private fun changeStatWordsPerMinute() {
        _gameState.update {
            if (it.timeLeftMillis <= 0) return
            val timeSpent = GAME_DURATION_MILLIS - it.timeLeftMillis
            val predictedWordsInGameDuration = it.correct * (GAME_DURATION_MILLIS / timeSpent)
            val gameDurationsInMinute = 1.minutes.inWholeMilliseconds / GAME_DURATION_MILLIS
            it.copy(
                wordsPerMin = (predictedWordsInGameDuration * gameDurationsInMinute).toInt()
            )
        }
    }

    private var timer : Timer? = null
    private fun manageTimer(typeState: TypeState) {
        // Only start timer on first enter
        if (typeState.currentInputWord.isNotBlank() && timer != null) return

        _gameState.update { it.copy(gamePhase = GamePhase.Game) }
        timer = fixedRateTimer(period = 10L) {
            _gameState.update {
                it.copy(timeLeftMillis = it.timeLeftMillis - 10L)
            }
            changeStatWordsPerMinute()
            // On game finish
            if (_gameState.value.timeLeftMillis == 0L) {
                statsRepository.saveGameResults(gameState = gameState.value)
                _gameState.update { it.copy(gamePhase = GamePhase.Endgame) }
                timer?.cancel()
            }
        }
    }

    companion object {
        val GAME_DURATION_MILLIS : Long = 20.seconds.inWholeMilliseconds
    }
}