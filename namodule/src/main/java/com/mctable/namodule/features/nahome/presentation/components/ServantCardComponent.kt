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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mctable.commons.ds.utils.emptyString
import com.mctable.commons.ds.utils.enums.ServantClasses
import com.mctable.namodule.features.nahome.domain.model.ServantModel


@Composable
fun ServantCardComponent(
    modifier: Modifier = Modifier,
    servantModel: ServantModel
) {
    Card(
        modifier = Modifier
            .testTag("servant-card-tag")
            .then(modifier)
            .shadow(
                elevation = 10.dp,
                ambientColor = DefaultShadowColor,
                clip = 10.dp > 0.dp,
                spotColor = DefaultShadowColor,
            ),
    ) {
        ListItem(
            modifier = Modifier.testTag("servant-list-item-tag"),
            headlineContent = {
                Text(
                    modifier = Modifier.testTag("servant-name-tag"),
                    text = servantModel.name,
                    style = MaterialTheme.typography.labelLarge
                )
            },
            leadingContent = {
                AsyncImage(
                    modifier = Modifier
                        .testTag("servant-image-tag")
                        .height(56.dp)
                        .width(56.dp),
                    model = servantModel.characterAssetsModel.characterFaces.first,
                    contentDescription = emptyString,
                )
            },
            trailingContent = {
                Image(
                    modifier = Modifier
                        .testTag("servant-class-image-tag")
                        .size(40.dp),
                    painter = painterResource(
                        id = ServantClasses.values().find { it.key == servantModel.className }?.icon
                            ?: ServantClasses.ALL.icon
                    ),
                    contentDescription = servantModel.name,
                )
            },
            supportingContent = {
                Column {
                    Text(
                        modifier = Modifier.testTag("servant-class-name-tag"),
                        text = servantModel.className,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        servantModel.cards.forEach {
                            Image(
                                modifier = Modifier
                                    .testTag("servant-card-image-tag-${it.key}")
                                    .size(40.dp),
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