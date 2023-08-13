package yakov.dev.type_hero.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import yakov.dev.type_hero.presentation.navigation.animation.EnterAnimation
import yakov.dev.type_hero.presentation.navigation.animation.ExitAnimation
import yakov.dev.type_hero.presentation.screen.game.ScreenGame
import yakov.dev.type_hero.presentation.screen.menu.ScreenMenu
import yakov.dev.type_hero.presentation.screen.statistics.ScreenStatistics

@[Composable]
fun NavComponent() {
    val (menuEnterTransition, setMenuEnterTransition) = remember { mutableStateOf<EnterAnimation>(EnterAnimation.SlideRight) }
    val (menuExitTransition, setMenuExitTransition) = remember { mutableStateOf<ExitAnimation>(ExitAnimation.SlideDown) }
    Scaffold(
        topBar = { MyTopAppBar() }
    ) { scaffoldPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.Menu.name,
            modifier = Modifier.padding(scaffoldPadding)
        ) {
            composable(
                route = Screen.Menu.name,
                enterTransition = menuEnterTransition.transition,
                exitTransition = menuExitTransition.transition
            ) {
                ScreenMenu(
                    toGame = {
                        navController.navigate(Screen.Game.name)
                        setMenuExitTransition(ExitAnimation.SlideLeft)
                    },
                    toStatistics = {
                        navController.navigate(Screen.Statistics.name)
                        setMenuExitTransition(ExitAnimation.SlideDown)
                    }
                )
            }
            composable(
                route = Screen.Game.name,
                enterTransition = { slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(1000)) },
                exitTransition = { slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(1000)) }
            ) {
                LaunchedEffect(Unit) {
                    setMenuEnterTransition(EnterAnimation.SlideRight)
                }
                ScreenGame()
            }
            composable(
                route = Screen.Statistics.name,
                enterTransition = { slideInVertically(initialOffsetY = {-it}, animationSpec = tween(1000)) },
                exitTransition = { slideOutVertically(targetOffsetY = {-it}, animationSpec = tween(1000)) }
            ) {
                LaunchedEffect(Unit) {
                    setMenuEnterTransition(EnterAnimation.SlideUp)
                }
                ScreenStatistics()
            }
        }
    }
}

enum class Screen {
    Menu, Game, Statistics
}