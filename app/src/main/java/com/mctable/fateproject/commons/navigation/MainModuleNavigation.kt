package com.mctable.fateproject.commons.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mctable.commons.ds.navigation.Routes
import com.mctable.fateproject.splash.presentation.views.SplashPage
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage

fun NavGraphBuilder.mainModuleNavigation() {
    composable(Routes.SPLASH) {
        SplashPage()
    }
}