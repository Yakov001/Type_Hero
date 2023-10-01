package yakov.dev.type_hero.presentation.screen.statistics.util

import yakov.dev.type_hero.domain.entity.GameResult

fun GameResult.toPresentation() : GameResultPresentation = GameResultPresentation(
    stats = listOf(
        GameResultStat.Accuracy(value = accuracy),
        GameResultStat.WordsPerMinute(value = wordsPerMin.toFloat())
    )
)

data class GameResultPresentation(
    val stats : List<GameResultStat>
)

sealed class GameResultStat(
    val value : Float,
    val name : String
) {
    class Accuracy(value: Float) : GameResultStat(value = value, name = "Accuracy")
    class WordsPerMinute(value: Float) : GameResultStat(value = value, name = "Words Per Minute")
}