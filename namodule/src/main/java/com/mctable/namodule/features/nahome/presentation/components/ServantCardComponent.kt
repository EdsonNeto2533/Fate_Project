package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mctable.commons.ds.utils.emptyString

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun servantCardComponent() {
    ListItem(
        headlineText = {
            Text(text = "alow")
        },
        leadingContent = {
            AsyncImage(
                modifier = Modifier.height(56.dp).width(56.dp),
                model = "https://i.pinimg.com/474x/58/3e/36/583e368d0fa6b107be85d71bca17bc1d.jpg",
                contentDescription = emptyString,
            )
        },
        supportingText = {
            Text(text = "alow 3")
        },
        shadowElevation = 10.dp,
        tonalElevation = 10.dp
    )
}