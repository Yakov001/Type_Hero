package yakov.dev.type_hero.domain.repository

interface StatsRepository {

    fun onWordFinish(isCorrect : Boolean)

    fun onInput(char : Char, isCorrect: Boolean)

}