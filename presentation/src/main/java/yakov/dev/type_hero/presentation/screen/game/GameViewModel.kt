package yakov.dev.type_hero.presentation.screen.game

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import yakov.dev.type_hero.domain.use_case.InputUseCase
import yakov.dev.type_hero.domain.entity.GameState
import yakov.dev.type_hero.domain.entity.TypeState
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val inputUseCase: InputUseCase
) : ViewModel() {

    val typeState : StateFlow<TypeState> = inputUseCase.typeState
    val gameState : StateFlow<GameState> = inputUseCase.gameState

    fun onInput(input : String) = inputUseCase.onInput(input)
}