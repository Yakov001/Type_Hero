package yakov.dev.type_hero.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import yakov.dev.type_hero.presentation.screen.game.ScreenGame

@Composable
fun NavComponent() {
    val (fabAction, setFabAction) = remember { mutableStateOf({})}
    val (fabIcon, setFabIcon) = remember { mutableStateOf(Icons.Default.ArrowForward)}
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = fabAction) {
                Icon(imageVector = fabIcon, contentDescription = "Next Screen")
            }
        }
    ) { scaffoldPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.Game.name,
            modifier = Modifier.padding(scaffoldPadding)
        ) {
            composable(
                route = Screen.Game.name
            ) {
                LaunchedEffect(Unit) {
                    setFabAction {  }
                    setFabIcon(Icons.Default.ArrowForward)
                }
                ScreenGame()
            }
        }
    }
}

enum class Screen {
    Game
}