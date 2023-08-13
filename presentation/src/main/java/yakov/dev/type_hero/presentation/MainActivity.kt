package yakov.dev.type_hero.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import yakov.dev.type_hero.presentation.navigation.NavComponent
import yakov.dev.type_hero.presentation.theme.TypeHeroTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypeHeroTheme {
                NavComponent()
            }
        }
    }
}