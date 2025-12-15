package com.aagamshah.urbansociety.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aagamshah.urbansociety.presentation.loginscreen.LoginScreen

@Composable
fun RootNavigation() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = RootRoute.LoginRoute
    ) {

        composable<RootRoute.LoginRoute> {
            LoginScreen()
        }

        composable<RootRoute.MainRoute> {
//            MainContainerScreen()
        }
    }
}
