package com.yash.apps.weatherapp.domain.usecases.weather

import com.yash.apps.weatherapp.domain.model.CityWeather
import com.yash.apps.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentWeather(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): Flow<CityWeather> {
        return weatherRepository.getCurrentWeather(cityName)
    }
}