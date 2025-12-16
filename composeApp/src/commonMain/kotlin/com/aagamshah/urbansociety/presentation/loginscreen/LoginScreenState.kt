package com.aagamshah.urbansociety.presentation.loginscreen

data class LoginScreenState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)