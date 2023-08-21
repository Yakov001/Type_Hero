package yakov.dev.type_hero.presentation.screen.game

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import yakov.dev.type_hero.presentation.screen.game.components.FeedbackTextArea
import yakov.dev.type_hero.presentation.screen.game.components.GameStatsArea
import yakov.dev.type_hero.presentation.screen.game.components.PlayerTextField

@Composable
fun ScreenGame(
    viewModel : GameViewModel = hiltViewModel()
) {
    val typeState = viewModel.typeState.collectAsState().value
    val gameState = viewModel.gameState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameStatsArea(gameState = gameState)
        FeedbackTextArea(typeState = typeState)
        AnimatedVisibility(visible = gameState.timeLeftMillis > 0) {
            PlayerTextField(
                text = typeState.currentInputWord,
                onTextChange = { viewModel.onInput(it) }
            )
        }
    }
}