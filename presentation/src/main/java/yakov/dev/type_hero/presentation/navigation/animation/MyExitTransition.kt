package yakov.dev.type_hero.presentation.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry

sealed interface MyExitTransition : (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>) -> ExitTransition {

    private companion object {
        val ANIMATION_SPEC : FiniteAnimationSpec<IntOffset> = tween(700)
    }

    object SlideUp : MyExitTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): ExitTransition = slideOutVertically(targetOffsetY = { -it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideDown : MyExitTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): ExitTransition = slideOutVertically(targetOffsetY = { it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideRight : MyExitTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): ExitTransition = slideOutHorizontally(targetOffsetX = { it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideLeft : MyExitTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): ExitTransition = slideOutHorizontally(targetOffsetX = { -it }, animationSpec = ANIMATION_SPEC)
    }

}
