package yakov.dev.type_hero.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import yakov.dev.type_hero.data.database.GameResultDatabase
import yakov.dev.type_hero.data.utils.toDbModel
import yakov.dev.type_hero.data.utils.toDomain
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.entity.GameState
import yakov.dev.type_hero.domain.repository.StatsRepository
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(
    private val db : GameResultDatabase
): StatsRepository {

    override fun onWordFinish(isCorrect: Boolean) {
        // todo
    }

    override fun onCharInput(char: Char, isCorrect: Boolean) {
        // todo - save stats for each char (speed, accuracy)
    }

    override fun saveGameResults(gameState: GameState) {
        db().upsertGameResult(gameState.toDbModel())
        Log.d("StatsRepositoryImpl", "saveGameResults: $gameState")
    }

    override fun getGameResults(): Flow<List<GameResult>> {
        return db().getAllGamesResults().map { list -> list.map { it.toDomain() } }
    }
}