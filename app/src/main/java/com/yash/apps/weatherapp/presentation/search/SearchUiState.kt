package com.yash.apps.weatherapp.presentation.search

import com.yash.apps.weatherapp.domain.model.CityWeather

data class SearchUiState(
    val searchValue: String? = null,
    val searchResult: CityWeather? = null
)
