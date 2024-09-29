package com.mctable.fateproject.splash.presentation.views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mctable.core.utils.extensions.getViewModel
import com.mctable.fateproject.splash.presentation.viewmodel.SplashPageViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashPage() {

    val context = LocalContext.current as ComponentActivity
    val viewModel: SplashPageViewModel = context.getViewModel()

    LaunchedEffect(key1 = "key") {
        delay(3000)
        viewModel.navigateToNaHome()
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome",
                    modifier = Modifier.padding(16.dp)
                )
                CircularProgressIndicator()
            }
        },
    )
}