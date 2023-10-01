package yakov.dev.type_hero.presentation.screen.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.use_case.StatisticsUseCase
import yakov.dev.type_hero.presentation.screen.statistics.util.GameResultPresentation
import yakov.dev.type_hero.presentation.screen.statistics.util.toPresentation
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    statisticsUseCase: StatisticsUseCase
) : ViewModel() {

    val statistics : StateFlow<List<GameResultPresentation>> = statisticsUseCase.stats.map { list -> list.map { it.toPresentation() } }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    init {
        viewModelScope.launch(Dispatchers.IO) { statisticsUseCase() }
    }
}