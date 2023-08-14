package yakov.dev.type_hero.domain.repository

import kotlinx.coroutines.flow.Flow
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.entity.GameState

interface StatsRepository {

    fun onWordFinish(isCorrect : Boolean)

    fun onCharInput(char : Char, isCorrect: Boolean)

    fun saveGameResults(gameState: GameState)

    fun getGameResults() : Flow<List<GameResult>>
}