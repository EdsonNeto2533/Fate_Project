package com.mctable.fateproject.commons.navigation

import android.content.Intent
import androidx.core.app.ComponentActivity
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FeatureModuleRef
import com.mctable.namodule.NaMainActivity

object FateNavigationModules {

    fun navigateToModule(
        activity: ComponentActivity,
        featureModuleRef: FeatureModuleRef,
        fateNavigation: FateNavigation,
        route: String?
    ) {
        when(featureModuleRef){
            FeatureModuleRef.NA -> {
                activity.startActivity(Intent(activity, NaMainActivity::class.java))
            }
        }
    }
}