package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ServantListErrorState() {
    Text(text = "error")
    Box(
        modifier = Modifier
            .background(color = Color(200, 255, 200, 0))
            .width(200.dp)
            .height(200.dp)
    )
}