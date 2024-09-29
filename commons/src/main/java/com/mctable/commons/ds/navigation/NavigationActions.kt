package com.mctable.commons.ds.navigation

import androidx.navigation.NavOptionsBuilder

sealed interface NavigationActions {
    data class Navigate(
        val destination: String,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationActions

    object NavigateUp : NavigationActions
}