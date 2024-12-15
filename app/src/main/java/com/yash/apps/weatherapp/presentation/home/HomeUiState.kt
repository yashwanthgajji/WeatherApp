package com.yash.apps.weatherapp.presentation.home

import com.yash.apps.weatherapp.domain.model.CityWeather

sealed class HomeUiState() {
    object Loading : HomeUiState()
    object Error: HomeUiState()
    data class Success(
        val location: String? = null,
        val cityWeather: CityWeather = CityWeather()
    ): HomeUiState()
}
