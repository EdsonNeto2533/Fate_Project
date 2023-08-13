package com.mctable.fateproject.commons.navigation

import androidx.core.app.ComponentActivity
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FeatureModuleRef

object FateNavigationModules {

    fun navigateToModule(
        activity: ComponentActivity,
        featureModuleRef: FeatureModuleRef,
        fateNavigation: FateNavigation,
        route: String?
    ) {
        when(featureModuleRef){
            FeatureModuleRef.NA -> {

            }
        }
    }
}