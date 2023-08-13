package yakov.dev.type_hero.presentation.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry

sealed class EnterAnimation(
    val transition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null
) {
    private companion object {
        val ANIMATION_SPEC : FiniteAnimationSpec<IntOffset> = tween(700)
    }

    object SlideUp : EnterAnimation(
        transition = { slideInVertically(initialOffsetY = { it }, animationSpec = ANIMATION_SPEC)
    })
    object SlideRight : EnterAnimation(
        transition = { slideInHorizontally(initialOffsetX = { -it }, animationSpec = ANIMATION_SPEC)
    })
}
