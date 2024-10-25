package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.components.shimmerBrushComponent

@Composable
fun ServantListLoadingState() {
    LazyColumn(modifier = Modifier.testTag("servant-lazy-column-loading-tag")
        .padding(16.dp)
        .wrapContentHeight(),
        content = {
            items(count = 10) {
                Box(
                    modifier = Modifier.testTag("servant-loading-card-tag-$it")
                        .background(shimmerBrushComponent(targetValue = 1300f))
                        .fillMaxWidth()
                        .height(80.dp)
                )
                Box(modifier = Modifier.height(16.dp))
            }
        }
    )
}