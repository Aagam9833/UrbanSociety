package com.aagamshah.urbansociety.presentation.loginscreen

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)