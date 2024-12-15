package com.yash.apps.weatherapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yash.apps.weatherapp.presentation.home.components.MoreDetailsSection
import com.yash.apps.weatherapp.presentation.home.components.WeatherConditionsComponent

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val uiState by viewModel.homeUiState.collectAsState()
    when (uiState) {
        is HomeUiState.Success -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                val successUiState = uiState as HomeUiState.Success
                WeatherConditionsComponent(
                    condition = successUiState.cityWeather.condition,
                    conditionIcon = "https:${successUiState.cityWeather.conditionIcon}",
                    location = successUiState.cityWeather.cityName,
                    temperature = getTemperatureString(successUiState.cityWeather.temperature)
                )
                MoreDetailsSection(
                    humidity = successUiState.cityWeather.humidity.toString(),
                    uvIndex =successUiState.cityWeather.uvIndex.toString(),
                    feelsLike = "${getTemperatureString(successUiState.cityWeather.feelsLike)}°"
                )
            }
        }

        is HomeUiState.Loading -> {

        }

        is HomeUiState.Error -> {

        }
    }
}

fun getTemperatureString(value: Double): String {
    return if (value % 1.0 == 0.0) {
        value.toInt().toString()
    } else {
        value.toString()
    }
}