package com.mctable.namodule.features.nahome.presentation.pages


import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mctable.commons.ds.components.DefaultAppBarComponent
import com.mctable.commons.ds.components.dialogs.LoadingDialog
import com.mctable.core.utils.classes.UIState
import com.mctable.core.utils.extensions.getViewModel
import com.mctable.namodule.features.nahome.presentation.components.ServantListErrorState
import com.mctable.namodule.features.nahome.presentation.components.ServantListLoadingState
import com.mctable.namodule.features.nahome.presentation.components.ServantListSuccessState
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel


@Composable
fun NaHomePage() {
    val context = LocalContext.current as ComponentActivity
    val viewModel: NaHomePageViewModel = context.getViewModel()
    val state = viewModel.servantState.collectAsState().value
    val showLoadingDialogState = viewModel.showLoadingDialogState.collectAsState().value
    var searchText by remember {
        mutableStateOf("")
    }

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
                        },
                        textCleared = {
                            searchText = ""
                            viewModel.resetList()
                        },
                        searchClicked = {
                            searchText = it
                            viewModel.loadServantsByName(it)
                        },
                        searchedText = searchText
                    )
                }

                UIState.Idle -> {

                }
            }
        },
    )
}