package yakov.dev.type_hero.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@[Composable OptIn(ExperimentalMaterial3Api::class)]
fun MyTopAppBar() {
    TopAppBar(
        title = {},
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        actions = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }
    )
}