package com.aagamshah.urbansociety.presentation.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Effect>(
    protected val coroutineScope: CoroutineScope
) {

    private val _effect = MutableSharedFlow<Effect>()
    val effect: SharedFlow<Effect> = _effect

    protected fun emitEffect(effect: Effect) {
        coroutineScope.launch {
            _effect.emit(effect)
        }
    }
}