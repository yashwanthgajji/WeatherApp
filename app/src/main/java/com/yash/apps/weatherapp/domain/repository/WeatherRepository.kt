package com.yash.apps.weatherapp.domain.repository

import com.yash.apps.weatherapp.domain.model.CityWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeather(cityName: String): Flow<CityWeather>
}