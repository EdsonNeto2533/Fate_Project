package com.mctable.fateproject.commons.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.NavigationActions
import com.mctable.commons.ds.navigation.Routes
import com.mctable.commons.ds.utils.ObserveAsEvents
import com.mctable.fateproject.splash.presentation.views.SplashPage
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage

@Composable
fun AppNavigation(
    fateNavigation: FateNavigation
) {

    val navController = rememberNavController()

    ObserveAsEvents(flow = fateNavigation.navigationActions) { action ->
        when (action) {
            is NavigationActions.Navigate -> {
                navController.navigate(action.destination) {
                    action.navOptions(this)
                }
            }

            NavigationActions.NavigateUp -> {
                navController.navigateUp()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashPage()
        }

        composable(Routes.NA_HOME_PAGE) {
            NaHomePage()
        }
    }

}