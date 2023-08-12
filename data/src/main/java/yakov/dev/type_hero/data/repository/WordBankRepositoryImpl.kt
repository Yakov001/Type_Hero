package yakov.dev.type_hero.data.repository

import yakov.dev.type_hero.data.data_source.WordBank
import yakov.dev.type_hero.domain.repository.WordBankRepository

class WordBankRepositoryImpl : WordBankRepository {

    override fun getRandomWords(amount: Int): List<String> {
        return WordBank.randomWords(amount)
    }

    override fun getAdditionalWords(amount: Int): List<String> {
        return WordBank.randomWords(amount)
    }
}