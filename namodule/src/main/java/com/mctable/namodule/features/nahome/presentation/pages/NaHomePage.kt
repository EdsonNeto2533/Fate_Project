package com.mctable.namodule.features.nahome.presentation.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.shimmerBrushComponent
import com.mctable.core.utils.classes.UIState
import com.mctable.core.utils.extensions.getViewModel
import com.mctable.namodule.NaMainActivity
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun NaHomePage() {
    val context = LocalContext.current as NaMainActivity
    val viewModel: NaHomePageViewModel = context.getViewModel()
    val state = viewModel.servantState.collectAsState().value

    viewModel.getServants()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            when (state) {
                is UIState.Loading -> {
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(shimmerBrushComponent(targetValue = 1300f))
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }

                }

                is UIState.Failure -> {
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "error")
                        Box(
                            modifier = Modifier
                                .background(color = Color(200, 300, 200, 0))
                                .width(200.dp)
                                .height(200.dp)
                        )
                    }
                }

                UIState.Idle -> {

                }

                is UIState.Success -> {
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        Text(
//                            text = state.data[0].name,
//                            modifier = Modifier
//                        )
                    }
                }
            }

        },
    )
}