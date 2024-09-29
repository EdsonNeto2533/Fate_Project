package com.mctable.fateproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.theme.FateProjectTheme
import com.mctable.fateproject.commons.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var fateNavigation: FateNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FateProjectTheme {
                AppNavigation(fateNavigation)
            }
        }
    }

}