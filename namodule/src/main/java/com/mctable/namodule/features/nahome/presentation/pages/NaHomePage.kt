package com.mctable.namodule.features.nahome.presentation.pages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mctable.core.utils.extensions.getViewModel
import com.mctable.namodule.NaMainActivity
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun NaHomePage() {
    val context = LocalContext.current as NaMainActivity
    val viewModel: NaHomePageViewModel = context.getViewModel()
    viewModel.servantState.collectAsState()

    viewModel.getServants()
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
                    text = "alow",
                    modifier = Modifier
                )
            }
        },
    )
}