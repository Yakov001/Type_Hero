package yakov.dev.type_hero.presentation.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry

sealed class ExitAnimation(
    val transition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null
) {
    private companion object {
        val ANIMATION_SPEC : FiniteAnimationSpec<IntOffset> = tween(700)
    }

    object SlideDown : ExitAnimation(
        transition = { slideOutVertically(animationSpec = ANIMATION_SPEC, targetOffsetY = { it }) }
    )

    object SlideLeft : ExitAnimation(
        transition = { slideOutHorizontally(animationSpec = ANIMATION_SPEC, targetOffsetX = { -it }) }
    )
}
