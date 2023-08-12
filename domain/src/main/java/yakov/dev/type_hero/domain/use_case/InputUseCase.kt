package yakov.dev.type_hero.domain.use_case

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import yakov.dev.type_hero.domain.entity.GameState
import yakov.dev.type_hero.domain.entity.TypeState
import yakov.dev.type_hero.domain.repository.WordBankRepository
import java.util.Collections.addAll
import javax.inject.Inject

class InputUseCase @Inject constructor(
    private val wordBankRepository : WordBankRepository
) {

    private val _typeState = MutableStateFlow(TypeState(gameWords = wordBankRepository.getRandomWords()))
    val typeState = _typeState.asStateFlow()

    private val _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()

    fun onInput(input: String) {
        when {
            // When we erased last char
            input.isBlank() && _typeState.value.currentInputWord.isNotBlank() -> {
                _typeState.update {
                    it.copy(currentInputWord = String())
                }
            }
            // If we enter space when input empty
            input.isBlank() -> return
            // When we want to finish this word and go to next one
            input.lastOrNull() == ' ' -> {
                _typeState.update {
                    val isCorrect = it.currentInputWord == it.gameWords[it.currentInputWordIndex]
                    if (isCorrect) {
                        _gameState.update { gameState ->
                            gameState.copy(
                                score = gameState.score + 1
                            )
                        }
                    }
                    it.copy(
                        currentInputWordIndex = it.currentInputWordIndex + 1,
                        currentInputWord = String(),
                        inputWords = it.inputWords.toMutableList().apply { add(isCorrect) }.toList()
                    )
                }
                addNewWords()
            }
            // Just entering the word...
            else -> _typeState.update { it.copy(currentInputWord = input) }
        }
    }

    private fun addNewWords() {
        // add new words only when our gameWords are running out (player is fast)
        if (_typeState.value.run{ gameWords.lastIndex - currentInputWordIndex > MINIMUM_LEFT }) return
        _typeState.update {
            val newWords = wordBankRepository.getAdditionalWords()
            it.copy(gameWords = it.gameWords.toMutableList().apply { addAll(newWords) }.toList())
        }
    }

    companion object {
        private const val MINIMUM_LEFT = 10
    }
}