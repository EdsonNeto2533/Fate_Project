package com.mctable.namodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage


@Composable
fun NaModuleNavigation(
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NaModuleRoutes.ROOT,
    ) {
        composable(NaModuleRoutes.ROOT) {
            NaHomePage()
        }
    }

}