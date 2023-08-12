package yakov.dev.type_hero.domain.repository

interface WordBankRepository {

    fun getRandomWords(amount : Int = START_WORDS) : List<String>

    fun getAdditionalWords(amount : Int = ADDITIONAL_WORDS) : List<String>

    companion object {
        const val START_WORDS = 40
        const val ADDITIONAL_WORDS = 20
    }
}