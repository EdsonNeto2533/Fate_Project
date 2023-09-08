package com.mctable.namodule.navigation

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun NaModuleNavigation(
    context: ComponentActivity
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NaModuleRoutes.ROOT,
    ) {
        composable(NaModuleRoutes.ROOT) {
            NaHomePage(naHomePageViewModel = ViewModelProvider(context).get())
        }
    }

}