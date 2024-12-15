package com.yash.apps.weatherapp.data.repository

import com.yash.apps.weatherapp.data.remote.WeatherApi
import com.yash.apps.weatherapp.data.remote.dto.CurrentWeatherResponse
import com.yash.apps.weatherapp.domain.model.CityWeather
import com.yash.apps.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
): WeatherRepository {
    override suspend fun getCurrentWeather(cityName: String): Flow<CityWeather> {
        try {
            val weatherResponse = weatherApi.getCurrentWeather(cityName = cityName)
            return flowOf(weatherResponse.convertToCityWeather())
        } catch (e: Exception) {
            return emptyFlow()
        }
    }
}

fun CurrentWeatherResponse.convertToCityWeather(): CityWeather {
    return CityWeather(
        cityName = location.name,
        temperature = current.temp_c,
        condition = current.condition.text,
        conditionIcon = current.condition.icon,
        humidity = current.humidity,
        uvIndex = current.uv,
        feelsLike = current.feelslike_c
    )
}