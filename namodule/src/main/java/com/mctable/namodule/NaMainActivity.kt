package com.mctable.namodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FeatureModuleRef
import com.mctable.commons.ds.theme.FateProjectTheme
import com.mctable.namodule.navigation.NaModuleNavigation
import javax.inject.Inject

class NaMainActivity : ComponentActivity() {

    @Inject
    lateinit var fateNavigation: FateNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FateProjectTheme {
                NaModuleNavigation()
            }
        }
    }

    fun navigate(featureModuleRef: FeatureModuleRef, route: String?) {
        fateNavigation.navigate(featureModuleRef, route)
    }
}