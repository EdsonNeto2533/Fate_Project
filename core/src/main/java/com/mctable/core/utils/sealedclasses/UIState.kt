package com.mctable.core.utils.sealedclasses

import com.mctable.core.utils.interfaces.Error

sealed class UIState<out T> {
    object Loading : UIState<Unit>()

    class Success<T>(val data: T) : UIState<T>()

    object Failure : UIState<Error>()
}
