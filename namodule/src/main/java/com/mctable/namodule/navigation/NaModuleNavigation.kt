package com.mctable.namodule.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mctable.commons.ds.navigation.Routes
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage

fun NavGraphBuilder.naModuleNavigation() {
    composable(Routes.NA_HOME_PAGE) {
        NaHomePage()
    }
}