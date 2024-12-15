package com.yash.apps.weatherapp.data.remote.dto

data class CurrentWeatherResponse(
    val current: Current,
    val location: Location
)