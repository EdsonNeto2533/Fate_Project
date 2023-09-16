package com.mctable.core.utils.classes

import com.mctable.core.utils.interfaces.Error

sealed class UIState<out T> {

    object Idle : UIState<Nothing>()
    object Loading : UIState<Nothing>()

    class Success<T>(val data: T) : UIState<T>()

    class Failure(val error: Error) : UIState<Nothing>()
}
