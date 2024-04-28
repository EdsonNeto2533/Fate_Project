package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
fun ServantCardComponent(
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
            headlineContent = {
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
                    model = servantModel.characterAssetsModel.characterFaces.first,
                    contentDescription = emptyString,
                )
            },
            supportingContent = {
                Column {
                    Text(
                        text = servantModel.className,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        servantModel.cards.forEach {
                            Image(
                                modifier = Modifier.size(40.dp),
                                painter = painterResource(id = it.drawable),
                                contentDescription = it.key,
                            )
                        }
                    }
                }
            }
        )
    }

}