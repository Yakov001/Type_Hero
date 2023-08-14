package yakov.dev.type_hero.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import yakov.dev.type_hero.data.entity.GameResultDb

@Dao
interface GameResultDao {

    @Upsert
    fun upsertGameResult(gameResultDb: GameResultDb)

    @Query("SELECT * FROM `games_results.db` ORDER BY finishTimeMillis ASC")
    fun getAllGamesResults() : Flow<List<GameResultDb>>

}