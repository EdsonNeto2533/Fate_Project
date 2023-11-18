package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.SearchBarComponent
import com.mctable.namodule.features.nahome.domain.model.ServantModel

@Composable
fun ServantListSuccessState(
    innerPadding: PaddingValues,
    servantsList: List<ServantModel>,
    loadMore: (Int) -> Unit,
) {
    val listState = rememberLazyListState()
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var shouldLoadMore by remember {
            mutableStateOf(false)
        }

        SearchBarComponent(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            placeholderText = "Buscar servo",
            searchClicked = {

            },
        )
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight(),
            state = listState,
            content = {
                items(count = servantsList.size) {
                    ServantCardComponent(servantModel = servantsList[it])

                    shouldLoadMore = it == servantsList.size - 1
                    LaunchedEffect(key1 = shouldLoadMore) {
                        if (shouldLoadMore)
                            loadMore.invoke(servantsList.size)
                    }
                }
            }
        )
    }
}