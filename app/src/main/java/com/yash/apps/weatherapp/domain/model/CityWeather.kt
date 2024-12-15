package com.yash.apps.weatherapp.domain.model

data class CityWeather(
    val cityName: String,
    val temperature: Double,
    val condition: String,
    val conditionIcon: String,
    val humidity: Int,
    val uvIndex: Double,
    val feelsLike: Double
)
