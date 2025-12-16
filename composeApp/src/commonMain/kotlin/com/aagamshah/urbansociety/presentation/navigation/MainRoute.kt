package com.aagamshah.urbansociety.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed interface MainRoute {
    val route: String
    val title: String
    val icon: ImageVector

    data object Home : MainRoute {
        override val route = "home"
        override val title = "Home"
        override val icon = Icons.Default.Home
    }

    data object Society : MainRoute {
        override val route = "society"
        override val title = "Society"
        override val icon = Icons.Default.Groups
    }

    data object Settings : MainRoute {
        override val route = "settings"
        override val title = "Settings"
        override val icon = Icons.Default.Settings
    }

    companion object {
        val bottomTabs = listOf(Home, Society, Settings)
    }
}
