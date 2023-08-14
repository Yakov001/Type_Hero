package yakov.dev.type_hero.presentation.screen.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import yakov.dev.type_hero.presentation.screen.menu.MenuViewModel

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
        Text(text = "Screen Statistics")
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = statsState) { gameResult ->
                Card(modifier = Modifier.fillMaxSize()) {
                    Text(text = gameResult.toString())
                }
            }
        }
    }
}