package com.mctable.fateproject.commons.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mctable.fateproject.splash.views.SplashPage

@Composable
fun MainModuleNavigation(
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainModuleNavigationRoutes.ROOT
    ) {
        composable(MainModuleNavigationRoutes.ROOT) {
            SplashPage()
        }
    }

}