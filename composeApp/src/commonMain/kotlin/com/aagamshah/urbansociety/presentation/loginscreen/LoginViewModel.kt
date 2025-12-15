package com.aagamshah.urbansociety.presentation.loginscreen

import com.aagamshah.urbansociety.domain.model.login.LoginModel
import com.aagamshah.urbansociety.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val coroutineScope: CoroutineScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob()
    )
) {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.OnUsernameChange ->
                _state.update { it.copy(username = intent.username) }

            is LoginIntent.OnPasswordChange ->
                _state.update { it.copy(password = intent.password) }

            LoginIntent.OnLoginClick ->
                login()
        }
    }

    private fun login() = coroutineScope.launch {
        val current = state.value

        if (current.username.isBlank() || current.password.isBlank()) {
            _effect.emit(LoginEffect.ShowError("Email and password required"))
            return@launch
        }

        _state.update { it.copy(isLoading = true) }

        try {
            val result = loginUseCase(
                LoginModel(current.username, current.password)
            )

            if (result.success) {
                _effect.emit(LoginEffect.NavigateToHome)
            } else {
                _effect.emit(
                    LoginEffect.ShowError(
                        result.errorMessage ?: "Something went wrong"
                    )
                )
            }
        } catch (e: Exception) {
            _effect.emit(
                LoginEffect.ShowError(e.message ?: "Login failed")
            )
        } finally {
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun clear() {
        coroutineScope.cancel()
    }
}
