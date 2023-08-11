package yakov.dev.type_hero.presentation.screen.game.components.feedback_text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import yakov.dev.type_hero.domain.entity.TypeState
import yakov.dev.type_hero.presentation.theme.span_style.spanStyle

@Composable
fun AnnotatedString.Builder.BuildFeedbackText(typeState : TypeState) {
    typeState.gameWords.forEachIndexed { i, gameWord ->
        when {
            // When we already input this word
            i < typeState.currentInputWordIndex -> {
                withStyle(typeState.inputWords[i].pastSpanStyle) {
                    append(gameWord)
                }
            }
            // When the word is being entered at the moment
            i == typeState.currentInputWordIndex/* && !typeState.isStartGame*/ -> {
                // If we entered to many symbols
                if (typeState.currentInputWord.length > gameWord.length) {
                    withStyle(MaterialTheme.spanStyle.currentIncorrect) {
                        append(gameWord)
                    }
                }
                // If we are doing it correctly
                else if (gameWord.startsWith(typeState.currentInputWord)) {
                    withStyle(MaterialTheme.spanStyle.currentCorrect) {
                        append(gameWord.substring(0, typeState.currentInputWord.length))
                    }
                    // add symbols remaining to finish the word
                    if (gameWord.length > typeState.currentInputWord.length) {
                        withStyle(MaterialTheme.spanStyle.currentFuture) {
                            append(gameWord.substring(typeState.currentInputWord.length, gameWord.length))
                        }
                    }
                }
                // If we made a mistake, show the whole word incorrect
                else {
                    withStyle(MaterialTheme.spanStyle.currentIncorrect) {
                        append(gameWord)
                    }
                }
            }
            // Future words to be entered
            else -> {
                withStyle(MaterialTheme.spanStyle.future) {
                    append(gameWord)
                }
            }
        }
        // Add space after each word
        append(" ")
    }
}

private val Boolean.pastSpanStyle : SpanStyle
    @Composable
    get() = MaterialTheme.spanStyle.let { if (this) it.pastCorrect else it.pastIncorrect }