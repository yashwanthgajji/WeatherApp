package com.yash.apps.weatherapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yash.apps.weatherapp.R
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchValue: String,
    readOnly: Boolean = false,
    onClick: (() -> Unit)? = null,
    onEditText: (String) -> Unit,
    onSearch: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(0xFFF2F2F2)),
        value = searchValue,
        onValueChange = onEditText,
        readOnly = readOnly,
        placeholder = {
            Text(
                text = "Search Location",
                fontSize = 15.sp,
                lineHeight = 22.5.sp,
                color = Color(0xFFC4C4C4)
            )
        },
        textStyle = TextStyle(
            fontSize = 15.sp,
            lineHeight = 22.5.sp,
        ),
        trailingIcon = {
            IconButton(onClick = onSearch) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search Button",
                    tint = Color(0xFFC4C4C4)
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        ),
        interactionSource = interactionSource
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    WeatherAppTheme {
        SearchBar(
            searchValue = "Dallas",
            onEditText = {},
            onSearch = {}
        )
    }
}