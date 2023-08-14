package yakov.dev.type_hero.data.utils

import yakov.dev.type_hero.data.entity.GameResultDb
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.entity.GameState

fun GameState.toDbModel() : GameResultDb = GameResultDb(
    finishTimeMillis = System.currentTimeMillis(),
    correct = correct,
    accuracy = accuracy,
    wrong = wrong,
    wordsPerMin = wordsPerMin
)

fun GameResultDb.toDomain() : GameResult = GameResult(
    finishTimeMillis = finishTimeMillis,
    correct = correct,
    wrong = wrong,
    accuracy = accuracy,
    wordsPerMin = wordsPerMin
)