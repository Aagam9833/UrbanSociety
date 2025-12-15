package com.aagamshah.urbansociety.domain.usecase

import com.aagamshah.urbansociety.domain.model.login.LoginModel
import com.aagamshah.urbansociety.domain.model.login.LoginResult
import com.aagamshah.urbansociety.domain.repository.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(loginModel: LoginModel): LoginResult {
        if (loginModel.username.isEmpty()) {
            return LoginResult(false, "Username cannot be empty")
        }

        if (loginModel.password.length < 8) {
            return LoginResult(false, "Password must be at least 8 characters")
        }

        return repository.login(loginModel)
    }
}
