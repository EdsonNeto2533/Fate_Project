package com.mctable.commons.ds.components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mctable.commons.R
import com.mctable.commons.ds.theme.md_theme_light_onPrimary
import com.mctable.commons.ds.theme.md_theme_light_surfaceTint
import com.mctable.commons.ds.utils.emptyString


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBarComponent(
    modifier: Modifier = Modifier,
    title: String? = null,
    backButtonClick: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .then(modifier)
            .testTag("default-app-bar-tag"),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = md_theme_light_surfaceTint),
        navigationIcon = {
            backButtonClick?.let {
                IconButton(modifier = Modifier.testTag("back-button-tag"), onClick = {
                    it.invoke()
                }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        stringResource(id = R.string.content_description_return),
                        modifier = Modifier.width(50.dp),
                        tint = md_theme_light_onPrimary
                    )
                }
            }
        },
        title = {
            title?.let {
                Text(
                    modifier = Modifier.testTag("title-tag"),
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = md_theme_light_onPrimary
                )
            } ?: run {
                Icon(
                    modifier = Modifier.height(28.dp).testTag("logo-tag"),
                    painter = painterResource(id = R.drawable.fgo_logo),
                    contentDescription = emptyString,
                    tint = md_theme_light_onPrimary
                )
            }
        }
    )
}
