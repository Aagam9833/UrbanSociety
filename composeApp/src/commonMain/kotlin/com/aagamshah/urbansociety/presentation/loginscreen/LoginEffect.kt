package com.aagamshah.urbansociety.presentation.loginscreen

sealed interface LoginEffect {
    object NavigateToHome : LoginEffect
    data class ShowError(val message: String) : LoginEffect
}