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

class GameFlowUseCase @Inject constructor(
    private val statsRepository: StatsRepository
) {

    private val _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()

    fun onWordFinish(isCorrect : Boolean) {
        statsRepository.onWordFinish(isCorrect)

        _gameState.update {
            if (isCorrect) it.copy(correct = it.correct + 1)
            else it.copy(wrong = it.wrong + 1)
        }
        changeStatWordsPerMinute()
    }

    fun onInput(input : String, typeState: TypeState) {
        val char = input.lastOrNull() ?: error("Empty strings not allowed here")
        // If last char of our input is equal to same position char in gameWords, we are correct
        val isCorrect = typeState.run { char == gameWords[currentInputWordIndex][input.lastIndex] }
        statsRepository.onCharInput(char = char, isCorrect = isCorrect)
        manageTimer(typeState)
    }

    private fun changeStatWordsPerMinute() {
        _gameState.update {
            if (it.timeLeftMillis <= 0) return
            val timeSpent = GAME_DURATION_MILLIS - it.timeLeftMillis
            it.copy(
                wordsPerMin = it.correct * (GAME_DURATION_MILLIS / timeSpent).toInt()
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
            if (_gameState.value.timeLeftMillis <= 0) {
                statsRepository.saveGameResults(gameState = gameState.value)
                _gameState.update { it.copy(gamePhase = GamePhase.Endgame) }
                timer?.cancel()
                timer = null
            }
        }
    }

    companion object {
        const val GAME_DURATION_MILLIS = 10_000L
    }
}