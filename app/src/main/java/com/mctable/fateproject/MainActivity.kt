package com.mctable.fateproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FeatureModuleRef
import com.mctable.commons.ds.theme.FateProjectTheme
import com.mctable.fateproject.commons.navigation.FateNavigationModules
import com.mctable.fateproject.commons.navigation.MainModuleNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), FateNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FateProjectTheme {
                MainModuleNavigation()
            }
        }
    }

    override fun navigate(featureModuleRef: FeatureModuleRef, route: String?) {
        FateNavigationModules.navigateToModule(
            this,
            featureModuleRef,
            this,
            route
        )
    }
}