package com.yash.apps.weatherapp.util

object HelperFunctions {
    fun getTemperatureString(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }
}