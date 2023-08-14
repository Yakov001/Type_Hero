package yakov.dev.type_hero.presentation.screen.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import yakov.dev.type_hero.domain.entity.GameResult
import yakov.dev.type_hero.domain.use_case.StatisticsUseCase
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    statisticsUseCase: StatisticsUseCase
) : ViewModel() {

    val statistics : StateFlow<List<GameResult>> = statisticsUseCase.stats

    init {
        viewModelScope.launch(Dispatchers.IO) { statisticsUseCase() }
    }
}