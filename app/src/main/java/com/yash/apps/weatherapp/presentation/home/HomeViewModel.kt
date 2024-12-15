package com.yash.apps.weatherapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.apps.weatherapp.domain.usecases.location.LocationUseCases
import com.yash.apps.weatherapp.domain.usecases.weather.WeatherUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases,
    private val locationUseCases: LocationUseCases
): ViewModel() {
    private var _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        locationUseCases.readSavedLocation().onEach { savedLocation ->
            if (savedLocation == null) {
                _homeUiState.value = HomeUiState.Success()
            } else {
                fetchCityWeather(savedLocation)
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun fetchCityWeather(cityName: String) {
        weatherUseCases.getCurrentWeather(cityName).collect {
            _homeUiState.value = HomeUiState.Success(location = cityName, cityWeather = it)
        }
    }
}