package yakov.dev.type_hero.domain.entity

import yakov.dev.type_hero.domain.use_case.GameFlowUseCase.Companion.GAME_DURATION_MILLIS

/**
 * State of current game
 *
 * val [accuracy] : Float = from 0f to 1f
 */
data class GameState(
    val correct : Int = 0,
    val wrong : Int = 0,
    val accuracy : Float = 0f,
    val wordsPerMin : Int = 0,

    val timeLeftMillis : Long = GAME_DURATION_MILLIS,
    val gamePhase : GamePhase = GamePhase.Idle,
)

enum class GamePhase {
    Idle, Game, Endgame
}