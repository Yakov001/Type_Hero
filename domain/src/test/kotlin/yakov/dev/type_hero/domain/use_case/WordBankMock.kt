package yakov.dev.type_hero.domain.use_case

import yakov.dev.type_hero.domain.repository.WordBankRepository

object WordBank {

    private const val WORDS = "illustrate cupcake pancake sand storm want abandon disregard life love friend sympathy deliberately jump run starve echo memory rapid strategy diversity equality equity equilibrium berry castle cage clever keen keep cope coal island ill query circle smell sad back needle me you take regard update split monk camp glorious shatter approve harmonious thirsty salve perpetual boredom get glory starve defeat alarm fire aviator aircraft steam pickle league rower boxer painter giant station reality rat"

    fun randomWords(amount: Int): List<String> = WORDS.split(" ").shuffled().take(amount).map { it.trim() }.filter { it.isNotBlank() }
}

val wordBankRepository = object : WordBankRepository {

    override fun getRandomWords(amount: Int): List<String> {
        return WordBank.randomWords(amount)
    }

    override fun getAdditionalWords(amount: Int): List<String> {
        return WordBank.randomWords(amount)
    }

}