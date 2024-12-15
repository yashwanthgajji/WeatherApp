package com.yash.apps.weatherapp.domain.usecases.location

data class LocationUseCases(
    val saveLocation: SaveLocation,
    val readSavedLocation: ReadSavedLocation
)
