package com.mctable.fateproject.splash.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.Routes
import javax.inject.Inject

class SplashPageViewModel @Inject constructor(
    private val fateNavigation: FateNavigation
) : ViewModel() {

    suspend fun navigateToNaHome() {
        fateNavigation.navigate(Routes.NA_HOME_PAGE)
    }
}