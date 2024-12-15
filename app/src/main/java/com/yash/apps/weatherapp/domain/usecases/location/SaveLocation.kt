package com.yash.apps.weatherapp.domain.usecases.location

import com.yash.apps.weatherapp.domain.manager.LocalUserManager

class SaveLocation(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(location: String) {
        localUserManager.saveLocation(location)
    }
}