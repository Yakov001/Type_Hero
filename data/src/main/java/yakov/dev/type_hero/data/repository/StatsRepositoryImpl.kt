package yakov.dev.type_hero.data.repository

import android.util.Log
import yakov.dev.type_hero.domain.repository.StatsRepository
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(): StatsRepository {

    override fun onWordFinish(isCorrect: Boolean) {
        Log.d("StatsRepositoryImpl", "onWordFinish, isCorrect = $isCorrect")
    }

    override fun onInput(char: Char, isCorrect: Boolean) {
        Log.d("StatsRepositoryImpl", "onInput, char = $char, isCorrect = $isCorrect")
    }
}