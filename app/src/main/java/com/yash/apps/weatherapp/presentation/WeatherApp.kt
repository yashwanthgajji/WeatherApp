package com.yash.apps.weatherapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yash.apps.weatherapp.presentation.home.HomeScreen
import com.yash.apps.weatherapp.presentation.home.HomeViewModel

@Composable
fun WeatherApp(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 80.dp, end = 16.dp),
        viewModel = viewModel
    )
}