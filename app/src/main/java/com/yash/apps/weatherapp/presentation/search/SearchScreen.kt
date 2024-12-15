package com.yash.apps.weatherapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.yash.apps.weatherapp.presentation.common.SearchBar
import com.yash.apps.weatherapp.presentation.search.components.ResultCityComponent
import com.yash.apps.weatherapp.presentation.search.components.SearchViewModel
import com.yash.apps.weatherapp.util.HelperFunctions.getTemperatureString

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
    navigateBack: () -> Unit
) {
    val uiState by viewModel.searchUiState.collectAsState()
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            modifier = Modifier.focusRequester(focusRequester),
            searchValue = uiState.searchValue ?: "",
            onEditText = {
                viewModel.onUpdate(uiState.copy(searchValue = it))
            },
            onSearch = viewModel::onSearch
        )
        Spacer(modifier = Modifier.height(32.dp))
        uiState.searchResult?.let {
            ResultCityComponent(
                location = it.cityName,
                temperature = getTemperatureString(it.temperature),
                condition = it.condition,
                conditionIcon = "https:${it.conditionIcon}",
                onClick = {
                    viewModel.onLocationClick()
                    navigateBack()
                }
            )
        }
    }
}