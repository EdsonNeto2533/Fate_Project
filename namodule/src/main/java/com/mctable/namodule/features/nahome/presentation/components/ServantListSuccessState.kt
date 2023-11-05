package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.SearchBarComponent
import com.mctable.namodule.features.nahome.domain.model.ServantModel

@Composable
fun ServantListSuccessState(
    innerPadding: PaddingValues,
    servantsList: List<ServantModel>
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBarComponent(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            placeholderText = "Buscar servo",
            searchClicked = {

            },
        )
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight(),
            content = {
                items(count = servantsList.size) {
                    ServantCardComponent(servantModel = servantsList[it])
                }
            }
        )
    }
}