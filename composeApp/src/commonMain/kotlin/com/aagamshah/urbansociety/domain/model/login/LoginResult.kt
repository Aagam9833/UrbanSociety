package com.aagamshah.urbansociety.domain.model.login

data class LoginResult(
    val success: Boolean,
    val errorMessage: String? = null
)
