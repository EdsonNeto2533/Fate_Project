package com.mctable.commons.ds.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mctable.commons.R
import com.mctable.commons.ds.utils.emptyString


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    placeholderText: String,
    initialText: String? = null,
    searchClicked: (String) -> Unit,
) {
    var text by remember {
        mutableStateOf(TextFieldValue(initialText ?: emptyString))
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().then(modifier),
        value = text,
        shape = RoundedCornerShape(28.dp),
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(text = placeholderText)
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions {
            searchClicked.invoke(text.text)
        },
        trailingIcon = {
            if (text.text.isEmpty()) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(horizontal = 8.dp)
                        .semantics { this.invisibleToUser() },
                    painter = painterResource(id = androidx.appcompat.R.drawable.abc_ic_search_api_material),
                    contentDescription = emptyString,
                )
            } else {
                IconButton(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(horizontal = 8.dp),
                    onClick = {
                        text = TextFieldValue(emptyString)
                    }) {
                    Icon(
                        painter = painterResource(id = androidx.appcompat.R.drawable.abc_ic_clear_material),
                        contentDescription = stringResource(id = R.string.content_description_clear_text),
                    )
                }
            }
        }
    )
}