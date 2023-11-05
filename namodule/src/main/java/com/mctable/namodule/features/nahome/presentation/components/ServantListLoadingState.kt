package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.shimmerBrushComponent

@Composable
fun ServantListLoadingState(
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight(),
            content = {
                items(count = 10) {
                    Box(
                        modifier = Modifier
                            .background(shimmerBrushComponent(targetValue = 1300f))
                            .fillMaxWidth()
                            .height(80.dp)
                    )
                    Box(modifier = Modifier.height(16.dp))
                }
            }
        )

    }
}