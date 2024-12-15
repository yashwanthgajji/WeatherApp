package com.yash.apps.weatherapp.data.remote

import com.yash.apps.weatherapp.data.remote.dto.CurrentWeatherResponse
import com.yash.apps.weatherapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") cityName: String,
        @Query("aqi") aqi: String = "no"
    ): CurrentWeatherResponse
}