package com.aagamshah.urbansociety.presentation.loginscreen

sealed interface LoginScreenIntent {
    data class OnUsernameChange(val username: String) : LoginScreenIntent
    data class OnPasswordChange(val password: String) : LoginScreenIntent
    object OnLoginClick : LoginScreenIntent
}
