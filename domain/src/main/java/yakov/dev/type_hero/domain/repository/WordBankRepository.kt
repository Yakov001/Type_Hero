package yakov.dev.type_hero.domain.repository

interface WordBankRepository {

    fun getRandomWords(amount : Int = START_WORDS) : List<String>

    companion object {
        const val START_WORDS = 20
    }
}