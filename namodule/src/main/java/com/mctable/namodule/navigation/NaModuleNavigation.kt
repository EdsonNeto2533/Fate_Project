package com.mctable.namodule.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mctable.commons.ds.navigation.Routes
import com.mctable.namodule.features.nahome.presentation.pages.NaHomePage

fun NavGraphBuilder.naModuleNavigation() {
    composable(Routes.NA_HOME_PAGE, enterTransition = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(700)
        )
    }) {
        NaHomePage()
    }
}