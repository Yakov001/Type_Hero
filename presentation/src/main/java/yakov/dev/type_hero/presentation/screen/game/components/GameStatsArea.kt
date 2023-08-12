package yakov.dev.type_hero.presentation.screen.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import yakov.dev.type_hero.domain.entity.GameState
import yakov.dev.type_hero.presentation.R
import yakov.dev.type_hero.presentation.screen.game.components.game_stats_area.GameStatBox
import kotlin.math.roundToInt

@Composable
fun GameStatsArea(gameState: GameState) {
    Row(
        modifier = Modifier.fillMaxWidth().height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        GameStatBox(stringResource(R.string.correct, gameState.correct))
        GameStatBox(stringResource(R.string.time_left, gameState.timeLeftMillis.toInt() / 1000))
        GameStatBox(stringResource(R.string.accuracy, (gameState.accuracy * 100).roundToInt()))
        GameStatBox(stringResource(R.string.words_per_min, gameState.wordsPerMin))
    }
}