package com.yash.apps.weatherapp.domain.model

data class CityWeather(
    val cityName: String = "",
    val temperature: Double = 0.0,
    val condition: String = "",
    val conditionIcon: String = "",
    val humidity: Int = 0,
    val uvIndex: Double = 0.0,
    val feelsLike: Double = 0.0
)
