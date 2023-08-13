package com.mctable.fateproject.commons.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object MainModuleNavigationRoutes {
    const val ROOT = "/"
}

@Composable
fun MainModuleNavigation(
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainModuleNavigationRoutes.ROOT
    ) {
        composable(MainModuleNavigationRoutes.ROOT) {
            Text(text = "home")
        }
    }

}