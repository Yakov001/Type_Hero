package yakov.dev.type_hero.presentation.screen.game.components.feedback_text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import yakov.dev.type_hero.domain.entity.TypeState

@Composable
fun AnnotatedString.Builder.BuildFeedbackText(typeState : TypeState) {
    typeState.gameWords.forEachIndexed { i, gameWord ->
        when {
            // When we already input this word
            i < typeState.currentInputWordIndex -> {
                withStyle(
                    styleInputWord(isCorrect = typeState.inputWords[i])
                ) {
                    append(gameWord)
                }
            }
            // When the word is being entered at the moment
            i == typeState.currentInputWordIndex && !typeState.isStartGame -> {
                // If we entered to many symbols
                if (typeState.currentInputWord.length > gameWord.length) {
                    withStyle(spanStyleError().copy(textDecoration = TextDecoration.Underline)) {
                        append(gameWord)
                    }
                }
                // If we are doing it correctly
                else if (gameWord.startsWith(typeState.currentInputWord)) {
                    withStyle(spanStyleCorrect().copy(textDecoration = TextDecoration.Underline)) {
                        append(gameWord.substring(0, typeState.currentInputWord.length))
                    }
                    // add symbols remaining to finish the word
                    if (gameWord.length > typeState.currentInputWord.length) {
                        withStyle(spanStyleToDo().copy(textDecoration = TextDecoration.Underline)) {
                            append(gameWord.substring(typeState.currentInputWord.length, gameWord.length))
                        }
                    }
                }
                // If we made a mistake, show the whole word incorrect
                else {
                    withStyle(spanStyleError().copy(textDecoration = TextDecoration.Underline)) {
                        append(gameWord)
                    }
                }
            }
            // Future words to be entered
            else -> {
                withStyle(
                    spanStyleToDo().copy(
                        textDecoration = if (i == 0) TextDecoration.Underline else null
                    )
                ) {
                    append(gameWord)
                }
            }
        }
        // Add space after each word
        append(" ")
    }
}

@Composable
private fun styleInputWord(isCorrect : Boolean) : SpanStyle {
    return if (isCorrect) spanStyleCorrect() else spanStyleError()
}

@Composable
private fun spanStyleError() = SpanStyle(color = MaterialTheme.colorScheme.error, textDecoration = TextDecoration.LineThrough)

@Composable
private fun spanStyleToDo() = SpanStyle(color = LocalTextStyle.current.color.copy(alpha = 0.6f))

@Composable
private fun spanStyleCorrect() = SpanStyle(color = LocalTextStyle.current.color)

private val TypeState.isStartGame : Boolean get() = currentInputWordIndex == 0 && currentInputWord.isBlank()