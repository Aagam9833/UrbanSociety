package com.aagamshah.urbansociety.domain.repository

import com.aagamshah.urbansociety.domain.model.login.LoginModel
import com.aagamshah.urbansociety.domain.model.login.LoginResult

interface LoginRepository {
    suspend fun login(loginModel: LoginModel): LoginResult
}