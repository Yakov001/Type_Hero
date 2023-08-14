package yakov.dev.type_hero.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import yakov.dev.type_hero.data.data_source.GameResultDao
import yakov.dev.type_hero.data.entity.GameResultDb

@Database(entities = [GameResultDb::class], version = 1)
abstract class GameResultDatabase : RoomDatabase() {

    abstract operator fun invoke() : GameResultDao

    companion object {
        const val DB_NAME = "games_results.db"
    }
}