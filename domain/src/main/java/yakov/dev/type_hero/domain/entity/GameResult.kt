package yakov.dev.type_hero.domain.entity

data class GameResult(
    val finishTimeMillis : Long,
    val correct : Int,
    val wrong : Int,
    val accuracy : Float,
    val wordsPerMin : Int
)
