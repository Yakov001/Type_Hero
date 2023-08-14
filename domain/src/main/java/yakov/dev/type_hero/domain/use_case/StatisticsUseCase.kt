package yakov.dev.type_hero.domain.use_case

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.repository.StatsRepository
import javax.inject.Inject

class StatisticsUseCase @Inject constructor(
    private val statsRepository: StatsRepository
) {
    private val _stats = MutableStateFlow<List<GameResult>>(emptyList())
    val stats = _stats.asStateFlow()

    suspend operator fun invoke() = _stats.emitAll(statsRepository.getGameResults())
}