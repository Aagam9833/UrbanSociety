package com.aagamshah.urbansociety.data.repositoryimpl

import com.aagamshah.urbansociety.domain.model.login.LoginModel
import com.aagamshah.urbansociety.domain.model.login.LoginResult
import com.aagamshah.urbansociety.domain.repository.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(loginModel: LoginModel): LoginResult {
        return when {
            loginModel.username != "Aagam" ->
                LoginResult(false, "Username not found")

            loginModel.password != "12345678" ->
                LoginResult(false, "Credentials do not match")

            else ->
                LoginResult(true, "Success")
        }
    }
}