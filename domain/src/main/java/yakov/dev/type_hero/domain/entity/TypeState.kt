package yakov.dev.type_hero.domain.entity

data class TypeState(
    val currentInputWord : String = String(),
    val currentInputWordIndex : Int = 0,
    val gameWords : List<String> = emptyList(),
    val inputWords : List<Boolean> = emptyList()
)
