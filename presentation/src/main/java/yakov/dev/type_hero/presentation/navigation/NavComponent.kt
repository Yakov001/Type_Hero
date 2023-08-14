package yakov.dev.type_hero.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import yakov.dev.type_hero.presentation.navigation.animation.MyEnterTransition
import yakov.dev.type_hero.presentation.navigation.animation.MyExitTransition
import yakov.dev.type_hero.presentation.screen.game.ScreenGame
import yakov.dev.type_hero.presentation.screen.menu.ScreenMenu
import yakov.dev.type_hero.presentation.screen.statistics.ScreenStatistics

@[Composable]
fun NavComponent() {
    val (menuEnterTransition, setMenuEnterTransition) = remember { mutableStateOf<MyEnterTransition>(MyEnterTransition.SlideUp) }
    val (menuExitTransition, setMenuExitTransition) = remember { mutableStateOf<MyExitTransition>(MyExitTransition.SlideDown) }
    val navController = rememberNavController()

    Scaffold(
        topBar = { MyTopAppBar(navController = navController) }
    ) { scaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Menu.name,
            modifier = Modifier.padding(scaffoldPadding)
        ) {
            composable(
                route = Screen.Menu.name,
                enterTransition = menuEnterTransition,
                exitTransition = menuExitTransition
            ) {
                ScreenMenu(
                    toGame = {
                        setMenuExitTransition(MyExitTransition.SlideLeft)
                        setMenuEnterTransition(MyEnterTransition.SlideRight)
                        navController.navigate(Screen.Game.name)
                    },
                    toStatistics = {
                        setMenuExitTransition(MyExitTransition.SlideDown)
                        setMenuEnterTransition(MyEnterTransition.SlideUp)
                        navController.navigate(Screen.Statistics.name)
                    }
                )
            }
            composable(
                route = Screen.Game.name,
                enterTransition = MyEnterTransition.SlideLeft,
                exitTransition = MyExitTransition.SlideRight
            ) {
                ScreenGame()
            }
            composable(
                route = Screen.Statistics.name,
                enterTransition = MyEnterTransition.SlideDown,
                exitTransition = MyExitTransition.SlideUp
            ) {
                ScreenStatistics()
            }
        }
    }
}

enum class Screen {
    Menu, Game, Statistics
}