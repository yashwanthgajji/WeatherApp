package com.yash.apps.weatherapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yash.apps.weatherapp.presentation.common.SearchBar
import com.yash.apps.weatherapp.presentation.home.components.MoreDetailsSection
import com.yash.apps.weatherapp.presentation.home.components.NoCityComponent
import com.yash.apps.weatherapp.presentation.home.components.WeatherConditionsComponent
import com.yash.apps.weatherapp.util.HelperFunctions.getTemperatureString

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navigateToSearch: () -> Unit
) {
    val uiState by viewModel.homeUiState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            searchValue = "",
            onEditText = {},
            readOnly = true,
            onClick = navigateToSearch,
            onSearch = {}
        )
        Spacer(modifier = Modifier.height(80.dp))
        when (uiState) {
            is HomeUiState.Success -> {
                val successUiState = uiState as HomeUiState.Success
                if (successUiState.location == null) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        NoCityComponent()
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        item {
                            WeatherConditionsComponent(
                                condition = successUiState.cityWeather.condition,
                                conditionIcon = "https:${successUiState.cityWeather.conditionIcon}",
                                location = successUiState.cityWeather.cityName,
                                temperature = getTemperatureString(successUiState.cityWeather.temperature)
                            )
                        }
                        item {
                            MoreDetailsSection(
                                humidity = successUiState.cityWeather.humidity.toString(),
                                uvIndex = successUiState.cityWeather.uvIndex.toString(),
                                feelsLike = "${getTemperatureString(successUiState.cityWeather.feelsLike)}°"
                            )
                        }
                    }
                }
            }

            is HomeUiState.Loading -> {

            }

            is HomeUiState.Error -> {

            }
        }
    }
}