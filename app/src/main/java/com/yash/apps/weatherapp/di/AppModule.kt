package com.yash.apps.weatherapp.di

import android.app.Application
import com.yash.apps.weatherapp.data.manager.LocalUserManagerImpl
import com.yash.apps.weatherapp.data.remote.WeatherApi
import com.yash.apps.weatherapp.data.repository.WeatherRepositoryImpl
import com.yash.apps.weatherapp.domain.manager.LocalUserManager
import com.yash.apps.weatherapp.domain.repository.WeatherRepository
import com.yash.apps.weatherapp.domain.usecases.location.LocationUseCases
import com.yash.apps.weatherapp.domain.usecases.location.ReadSavedLocation
import com.yash.apps.weatherapp.domain.usecases.location.SaveLocation
import com.yash.apps.weatherapp.domain.usecases.weather.GetCurrentWeather
import com.yash.apps.weatherapp.domain.usecases.weather.WeatherUseCases
import com.yash.apps.weatherapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi = weatherApi)
    }

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager {
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCases(weatherRepository: WeatherRepository): WeatherUseCases {
        return WeatherUseCases(
            getCurrentWeather = GetCurrentWeather(weatherRepository)
        )
    }

    @Provides
    @Singleton
    fun provideLocationUseCases(localUserManager: LocalUserManager): LocationUseCases {
        return LocationUseCases(
            saveLocation = SaveLocation(localUserManager),
            readSavedLocation = ReadSavedLocation(localUserManager)
        )
    }
}