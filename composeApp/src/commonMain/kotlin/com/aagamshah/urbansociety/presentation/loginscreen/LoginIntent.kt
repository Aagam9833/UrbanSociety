package com.aagamshah.urbansociety.presentation.loginscreen

sealed interface LoginIntent {
    data class OnUsernameChange(val username: String) : LoginIntent
    data class OnPasswordChange(val password: String) : LoginIntent
    object OnLoginClick : LoginIntent
}
