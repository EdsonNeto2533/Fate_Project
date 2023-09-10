package com.mctable.core.utils.extensions

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ComponentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return ViewModelProvider(this)[T::class.java]
}