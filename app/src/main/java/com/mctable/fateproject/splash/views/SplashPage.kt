package com.mctable.fateproject.splash.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SplashPage() {
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier.consumeWindowInsets(innerPadding)
            ) {
                Text(
                    text = "Welcome",
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                )
            }
        },
    )
}