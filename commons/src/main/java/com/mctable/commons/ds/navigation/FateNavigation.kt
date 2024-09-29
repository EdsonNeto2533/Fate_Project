package com.mctable.commons.ds.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

sealed interface FateNavigation {
    val startDestination: String
    val navigationActions: Flow<NavigationActions>

    suspend fun navigate(
        destination: String,
        navOptions: NavOptionsBuilder.() -> Unit = {}
    )

    suspend fun navigateUp()
}

class FateNavigationImpl(override val startDestination: String) : FateNavigation {
    private val _navigationActions = Channel<NavigationActions>()
    override val navigationActions: Flow<NavigationActions> = _navigationActions.receiveAsFlow()

    override suspend fun navigate(destination: String, navOptions: NavOptionsBuilder.() -> Unit) {
        _navigationActions.send(NavigationActions.Navigate(destination, navOptions))
    }

    override suspend fun navigateUp() {
        _navigationActions.send(NavigationActions.NavigateUp)
    }

}