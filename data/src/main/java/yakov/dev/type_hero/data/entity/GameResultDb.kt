package yakov.dev.type_hero.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import yakov.dev.type_hero.data.database.GameResultDatabase
import java.util.UUID

@Entity(tableName = GameResultDatabase.DB_NAME)
data class GameResultDb(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),
    val finishTimeMillis : Long,
    val correct : Int,
    val wrong : Int,
    val accuracy : Float,
    val wordsPerMin : Int
)
