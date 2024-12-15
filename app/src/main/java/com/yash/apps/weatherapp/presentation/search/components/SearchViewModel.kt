package com.yash.apps.weatherapp.presentation.search.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.apps.weatherapp.domain.usecases.location.LocationUseCases
import com.yash.apps.weatherapp.domain.usecases.weather.WeatherUseCases
import com.yash.apps.weatherapp.presentation.search.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases,
    private val locationUseCases: LocationUseCases
): ViewModel() {
    private var _searchUiState = MutableStateFlow(SearchUiState())
    val searchUiState: StateFlow<SearchUiState> = _searchUiState.asStateFlow()

    fun onUpdate(uiState: SearchUiState) {
        _searchUiState.value = uiState
    }

    fun onSearch() {
        viewModelScope.launch {
            searchUiState.value.searchValue?.let {
                weatherUseCases.getCurrentWeather(it).collect {
                    _searchUiState.value = _searchUiState.value.copy(
                        searchResult = it
                    )
                }
            }
        }
    }

    fun onLocationClick() {
        viewModelScope.launch {
            searchUiState.value.searchValue?.let { locationUseCases.saveLocation(it) }
        }
    }
}