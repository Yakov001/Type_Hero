package yakov.dev.type_hero.presentation.screen.game.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import yakov.dev.type_hero.domain.entity.TypeState

@Composable
fun FeedbackTextArea(
    typeState: TypeState
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                BuildGameText(typeState = typeState)
            }
        )
    }
}