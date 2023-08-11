package yakov.dev.type_hero.presentation.theme.span_style

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration

data class SpanStyles(
    val colorText : Color = Color.White,
    val colorCorrectText : Color = Color.Blue,
    val colorErrorText : Color = Color.Red
) {
    val pastCorrect : SpanStyle = SpanStyle(
        color = colorText.copy(alpha = 0.8f)
    )
    val pastIncorrect : SpanStyle = SpanStyle(
        color = colorErrorText.copy(alpha = 0.4f),
        textDecoration = TextDecoration.LineThrough
    )
    val currentCorrect : SpanStyle = SpanStyle(
        color = colorCorrectText,
        textDecoration = TextDecoration.Underline
    )
    val currentIncorrect : SpanStyle = SpanStyle(
        color = colorErrorText,
        textDecoration = TextDecoration.Underline
    )
    val currentFuture : SpanStyle = SpanStyle(
        color = colorCorrectText.copy(alpha = 0.4f),
        textDecoration = TextDecoration.Underline
    )
    val future : SpanStyle = SpanStyle(
        color = colorText.copy(alpha = 0.4f)
    )
}

val LocalSpanStyle = compositionLocalOf { SpanStyles() }

val MaterialTheme.spanStyle: SpanStyles
    @[Composable ReadOnlyComposable]
    get() = LocalSpanStyle.current