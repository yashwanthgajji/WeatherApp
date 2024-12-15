package com.yash.apps.weatherapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.apps.weatherapp.domain.usecases.weather.WeatherUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases
): ViewModel() {
    private var _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        fetchCityWeather("London")
    }

    private fun fetchCityWeather(cityName: String) {
        viewModelScope.launch {
            weatherUseCases.getCurrentWeather(cityName).collect {
                _homeUiState.value = HomeUiState.Success(it)
            }
        }
    }
}