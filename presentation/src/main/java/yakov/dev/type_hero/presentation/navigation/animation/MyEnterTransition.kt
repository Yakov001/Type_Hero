package yakov.dev.type_hero.presentation.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry

sealed interface MyEnterTransition : (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>) -> EnterTransition {

    private companion object {
        val ANIMATION_SPEC : FiniteAnimationSpec<IntOffset> = tween(700)
    }

    object SlideUp : MyEnterTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): EnterTransition = slideInVertically(initialOffsetY = { it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideDown : MyEnterTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): EnterTransition = slideInVertically(initialOffsetY = { -it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideRight : MyEnterTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): EnterTransition = slideInHorizontally(initialOffsetX = { -it }, animationSpec = ANIMATION_SPEC)
    }

    object SlideLeft : MyEnterTransition {
        override fun invoke(
            p1: AnimatedContentTransitionScope<NavBackStackEntry>
        ): EnterTransition = slideInHorizontally(initialOffsetX = { it }, animationSpec = ANIMATION_SPEC)
    }

}
