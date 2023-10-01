package yakov.dev.type_hero.presentation.screen.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import yakov.dev.type_hero.presentation.screen.statistics.components.NoStatsBanner
import yakov.dev.type_hero.presentation.screen.statistics.components.StatCard

@Composable
fun ScreenStatistics(
    viewModel: StatisticsViewModel = hiltViewModel()
) {
    val statsState = viewModel.statistics.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Statistics", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            if (statsState.isNotEmpty()) {
                buildList {
                    statsState.random().stats.indices.forEach { i ->
                        add(statsState.map { it.stats[i] })
                    }
                }.forEach {
                    item {
                        StatCard(stats = it.map { r -> r.value }, statsName = it.random().name)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                item { NoStatsBanner() }
            }
        }
    }
}