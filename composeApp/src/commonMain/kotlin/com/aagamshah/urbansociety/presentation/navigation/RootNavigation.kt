package com.aagamshah.urbansociety.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aagamshah.urbansociety.presentation.loginscreen.LoginScreen
import com.aagamshah.urbansociety.presentation.mainscreen.MainScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RootRoute.LoginRoute
    ) {

        composable<RootRoute.LoginRoute> {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(RootRoute.MainRoute) {
                        popUpTo(RootRoute.LoginRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<RootRoute.MainRoute> {
            MainScreen(
                onLogout = {
                    navController.navigate(RootRoute.LoginRoute) {
                        popUpTo(RootRoute.MainRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
