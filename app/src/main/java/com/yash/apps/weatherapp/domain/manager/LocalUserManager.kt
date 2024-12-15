package com.yash.apps.weatherapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveLocation(location: String)
    fun readSavedLocation(): Flow<String?>
}