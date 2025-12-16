package com.aagamshah.urbansociety.presentation.loginscreen

import com.aagamshah.urbansociety.domain.model.login.LoginModel
import com.aagamshah.urbansociety.domain.usecase.LoginUseCase
import com.aagamshah.urbansociety.presentation.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val loginUseCase: LoginUseCase,
    coroutineScope: CoroutineScope
) : BaseViewModel<LoginScreenEffect>(coroutineScope) {

    private val _state = MutableStateFlow(LoginScreenState())
    val state: StateFlow<LoginScreenState> = _state.asStateFlow()

    fun onIntent(intent: LoginScreenIntent) {
        when (intent) {
            is LoginScreenIntent.OnUsernameChange ->
                _state.update { it.copy(username = intent.username) }

            is LoginScreenIntent.OnPasswordChange ->
                _state.update { it.copy(password = intent.password) }

            LoginScreenIntent.OnLoginClick ->
                login()
        }
    }

    private fun login() = coroutineScope.launch {
        val current = state.value

        _state.update { it.copy(isLoading = true) }

        try {
            val result = loginUseCase(
                LoginModel(current.username, current.password)
            )

            if (result.success) {
                emitEffect(LoginScreenEffect.NavigateToHome)
            } else {
                emitEffect(
                    LoginScreenEffect.ShowError(
                        result.errorMessage ?: "Something went wrong"
                    )
                )
            }
        } catch (e: Exception) {
            emitEffect(LoginScreenEffect.ShowError(e.message ?: "Login failed"))
        } finally {
            _state.update { it.copy(isLoading = false) }
        }
    }

}
