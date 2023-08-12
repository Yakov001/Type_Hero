package yakov.dev.type_hero.presentation.screen.game.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yakov.dev.type_hero.domain.entity.TypeState
import yakov.dev.type_hero.presentation.screen.game.components.feedback_text.BuildFeedbackText
import yakov.dev.type_hero.presentation.theme.TypeHeroTheme
import kotlin.math.roundToInt

@Composable
fun FeedbackTextArea(
    typeState: TypeState
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(32.dp)
            .verticalScroll(
                state = scrollState,
                enabled = true
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                BuildFeedbackText(typeState = typeState)
            }
        )
    }
    val lineHeight = LocalDensity.current.run { LocalTextStyle.current.toParagraphStyle().lineHeight.value.dp.toPx() }
    val words = typeState.inputWords.size
    val wordsInLine = 4
    LaunchedEffect(words) {
        if (words > 0 && words % wordsInLine == 0) {
            scrollState.animateScrollTo(lineHeight.roundToInt() * (words / wordsInLine))
        }
    }
}