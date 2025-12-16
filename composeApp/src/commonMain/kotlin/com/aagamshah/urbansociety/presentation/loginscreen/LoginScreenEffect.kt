package com.aagamshah.urbansociety.presentation.loginscreen

sealed interface LoginScreenEffect {
    object NavigateToHome : LoginScreenEffect
    data class ShowError(val message: String) : LoginScreenEffect
}