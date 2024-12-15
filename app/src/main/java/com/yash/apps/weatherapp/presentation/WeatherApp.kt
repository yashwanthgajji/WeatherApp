package com.yash.apps.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yash.apps.weatherapp.presentation.navigator.AppNavigator

@Composable
fun WeatherApp(modifier: Modifier = Modifier) {
    AppNavigator(modifier = modifier)
}