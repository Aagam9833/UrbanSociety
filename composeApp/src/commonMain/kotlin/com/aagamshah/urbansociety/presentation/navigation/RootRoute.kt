package com.aagamshah.urbansociety.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface RootRoute {
    @Serializable
    data object LoginRoute : RootRoute

    @Serializable
    data object MainRoute : RootRoute
}