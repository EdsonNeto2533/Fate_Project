package com.mctable.namodule.features.nahome.presentation.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mctable.commons.ds.components.DefaultAppBarComponent
import com.mctable.commons.ds.components.dialogs.LoadingDialog
import com.mctable.core.utils.classes.UIState
import com.mctable.core.utils.extensions.getViewModel
import com.mctable.namodule.NaMainActivity
import com.mctable.namodule.features.nahome.presentation.components.ServantListErrorState
import com.mctable.namodule.features.nahome.presentation.components.ServantListLoadingState
import com.mctable.namodule.features.nahome.presentation.components.ServantListSuccessState
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NaHomePage() {
    val context = LocalContext.current as NaMainActivity
    val viewModel: NaHomePageViewModel = context.getViewModel()
    val state = viewModel.servantState.collectAsState().value
    val showLoadingDialogState = viewModel.showLoadingDialogState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.getServants()
    }

    if (showLoadingDialogState) {
        LoadingDialog()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultAppBarComponent()
        },
        content = { innerPadding ->
            when (state) {
                is UIState.Loading -> {
                    ServantListLoadingState(innerPadding = innerPadding)
                }

                is UIState.Failure -> {
                    ServantListErrorState(innerPadding = innerPadding)
                }

                is UIState.Success -> {
                    ServantListSuccessState(
                        innerPadding = innerPadding,
                        servantsList = state.data,
                        loadMore = {
                            viewModel.loadMoreServants(it)
                        })
                }

                UIState.Idle -> {

                }
            }
        },
    )
}