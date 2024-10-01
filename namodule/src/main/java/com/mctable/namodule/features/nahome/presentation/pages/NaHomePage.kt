package com.mctable.namodule.features.nahome.presentation.pages


import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.ClassFilterComponent
import com.mctable.commons.ds.components.DefaultAppBarComponent
import com.mctable.commons.ds.components.SearchBarComponent
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
    val enableLoadMore = viewModel.enableLoadMore.collectAsState().value
    var searchText by remember {
        mutableStateOf("")
    }

    var classFilter: String? by remember {
        mutableStateOf(null)
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
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBarComponent(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    placeholderText = "Search servant",
                    initialText = searchText,
                    searchClicked = {
                        classFilter = null
                        searchText = it
                        viewModel.loadServantsByName(it)
                    },
                    textCleared = {
                        classFilter = null
                        searchText = ""
                        viewModel.resetList()
                    }
                )

                ClassFilterComponent(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 8.dp
                    ),
                    selectedFilter = classFilter
                ) {
                    classFilter = it.key
                    viewModel.filterServantsByClass(it.key)
                }
                when (state) {
                    is UIState.Loading -> {
                        ServantListLoadingState()
                    }

                    is UIState.Failure -> {
                        ServantListErrorState()
                    }

                    is UIState.Success -> {
                        ServantListSuccessState(
                            servantsList = state.data,
                            loadMore = {
                                viewModel.loadMoreServants(it)
                            },
                            loadMoreEnabled = enableLoadMore
                        )
                    }

                    UIState.Idle -> {

                    }
                }
            }

        },
    )
}