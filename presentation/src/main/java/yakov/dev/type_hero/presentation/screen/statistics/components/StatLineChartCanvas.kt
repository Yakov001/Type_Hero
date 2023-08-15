package yakov.dev.type_hero.presentation.screen.statistics.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import yakov.dev.type_hero.domain.entity.GameResult

@Composable
fun StatLineChartCanvas(stats: List<GameResult>) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f))
    ) {
        val side = size.maxDimension
        drawLine(
            color = Color.White,
            start = Offset.Zero,
            end = Offset(
                x = 0f,
                y = side
            )
        )
        drawLine(
            color = Color.White,
            start = Offset(
                x = 0f,
                y = side
            ),
            end = Offset(
                x = side,
                y = side
            )
        )

        val path = buildStatPath(stats)
        drawPath(
            path = path,
            color = Color.White,
            style = Stroke(
                width = 1.dp.toPx()
            )
        )

    }
}

fun DrawScope.buildStatPath(stats: List<GameResult>) : Path {
    val side = size.maxDimension

    val yMin = stats.minOf { it.wordsPerMin }
    val yMax = stats.maxOf { it.wordsPerMin }
    val yRange = ((yMax - yMin) * 1.5f).coerceAtLeast(yMin * 2f)
    fun Int.toYAxis() : Float = this / yRange * side

    val xSegments = stats.size
    val xSegmentLen = side / xSegments
    fun Int.toXAxis() : Float = (this + 1) * xSegmentLen

    val path = Path().apply {
        moveTo(
            x = 0f,
            y = side
        )
        stats.forEachIndexed { i, gameResult ->
            lineTo(
                x = i.toXAxis(),
                y = gameResult.wordsPerMin.toYAxis()
            )
        }
    }
    return path
}