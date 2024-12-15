package com.yash.apps.weatherapp.domain.usecases.location

import com.yash.apps.weatherapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadSavedLocation(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<String?> {
        return localUserManager.readSavedLocation()
    }
}