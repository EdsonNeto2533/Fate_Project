package com.mctable.commons.ds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mctable.commons.ds.utils.enums.ServantClasses


@Composable
fun ClassFilterComponent(modifier: Modifier = Modifier, onClick: (ServantClasses) -> Unit) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(ServantClasses.values().size) { index ->
            val servantClass = ServantClasses.values()[index]
            Card(
                modifier = Modifier
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = Color.Transparent,
                        clip = 10.dp > 0.dp,
                        spotColor = Color.Transparent,
                    ),
                elevation = CardDefaults.elevatedCardElevation(),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = { onClick.invoke(servantClass) }
            ) {
                Image(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(4.dp),
                    painter = painterResource(id = servantClass.icon),
                    contentDescription = servantClass.name,
                )
            }
        }
    }
}


