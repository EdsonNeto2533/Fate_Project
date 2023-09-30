package com.mctable.core.utils.classes

import com.mctable.core.utils.interfaces.Error

sealed class UIState<out T> {

    object Idle : UIState<Nothing>()
    object Loading : UIState<Nothing>()

    data class Success<T>(val data: T) : UIState<T>()

    data class Failure(val error: Error) : UIState<Nothing>()
}
