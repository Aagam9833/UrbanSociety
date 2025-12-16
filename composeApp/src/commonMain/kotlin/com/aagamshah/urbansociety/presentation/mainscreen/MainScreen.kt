package com.aagamshah.urbansociety.presentation.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aagamshah.urbansociety.presentation.homescreen.HomeScreen
import com.aagamshah.urbansociety.presentation.navigation.MainRoute
import com.aagamshah.urbansociety.presentation.settingsscreen.SettingsScreen
import com.aagamshah.urbansociety.presentation.societyscreen.SocietyScreen

@Composable
fun MainScreen(
    onLogout: () -> Unit,
) {
    val navController = rememberNavController()

    val currentRoute by navController
        .currentBackStackEntryAsState()

    val showBottomBar = MainRoute.bottomTabs.any {
        it.route == currentRoute?.destination?.route
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    MainRoute.bottomTabs.forEach { tab ->
                        NavigationBarItem(
                            selected = currentRoute?.destination?.route == tab.route,
                            onClick = {
                                navController.navigate(tab.route) {
                                    popUpTo(MainRoute.Home.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(tab.icon, contentDescription = tab.title)
                            },
                            label = {
                                Text(tab.title)
                            }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = MainRoute.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(MainRoute.Home.route) {
                HomeScreen()
            }

            composable(MainRoute.Society.route) {
                SocietyScreen()
            }

            composable(MainRoute.Settings.route) {
                SettingsScreen(
                    onLogout = onLogout
                )
            }
        }
    }
}
