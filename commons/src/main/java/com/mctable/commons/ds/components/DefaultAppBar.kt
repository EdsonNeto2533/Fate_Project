package com.mctable.commons.ds.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mctable.commons.R
import com.mctable.commons.ds.theme.md_theme_light_onPrimary
import com.mctable.commons.ds.theme.md_theme_light_surfaceTint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    modifier: Modifier = Modifier,
    title: String?,
    backButtonClick: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier.then(modifier),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = md_theme_light_surfaceTint),
        navigationIcon = {
            backButtonClick?.let {
                IconButton(onClick = {
                    it.invoke()
                }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        "",
                        modifier = Modifier.width(50.dp),
                        tint = md_theme_light_onPrimary
                    )
                }
            } ?: run {
                Icon(
                    modifier = Modifier.width(50.dp),
                    painter = painterResource(id = R.drawable.fgo_logo),
                    contentDescription = "",
                    tint = md_theme_light_onPrimary
                )
            }

        },
        title = {
            title?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineMedium,
                        color = md_theme_light_onPrimary
                    )
                }
            }
        }
    )
}
