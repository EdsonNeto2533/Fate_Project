package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mctable.commons.ds.utils.emptyString
import com.mctable.namodule.features.nahome.domain.model.ServantModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun servantCardComponent(
    servantModel: ServantModel
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 10.dp,
                ambientColor = DefaultShadowColor,
                clip = 10.dp > 0.dp,
                spotColor = DefaultShadowColor,
            ),
    ) {
        ListItem(
            headlineText = {
                Text(
                    text = servantModel.name,
                    style = MaterialTheme.typography.labelLarge
                )
            },
            leadingContent = {
                AsyncImage(
                    modifier = Modifier
                        .height(56.dp)
                        .width(56.dp),
                    model = "https://i.pinimg.com/474x/58/3e/36/583e368d0fa6b107be85d71bca17bc1d.jpg",
                    contentDescription = emptyString,
                )
            },
            supportingText = {
                Column {
                    Text(
                        text = "Avenger",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Row {
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = com.mctable.commons.R.drawable.arts_card),
                            contentDescription = emptyString,
                        )
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = com.mctable.commons.R.drawable.arts_card),
                            contentDescription = emptyString,
                        )
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = com.mctable.commons.R.drawable.quick_card),
                            contentDescription = emptyString,
                        )
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = com.mctable.commons.R.drawable.quick_card),
                            contentDescription = emptyString,
                        )
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = com.mctable.commons.R.drawable.buster_card),
                            contentDescription = emptyString,
                        )
                    }
                }
            }
        )
    }

}