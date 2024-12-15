package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun WeatherConditionsComponent(
    modifier: Modifier = Modifier,
    condition: String,
    conditionIcon: String,
    location: String,
    temperature: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(123.dp),
            model = conditionIcon,
            contentDescription = condition,
            contentScale = ContentScale.Crop
        )
        LocationComponent(location = location)
        TemperatureDisplay(temperature = temperature)
    }
}

@Preview
@Composable
private fun WeatherConditionsComponentPreview() {
    WeatherAppTheme {
        WeatherConditionsComponent(
            condition = "Light rain",
            conditionIcon = "https://cdn.weatherapi.com/weather/64x64/night/296.png",
            location = "Indianapolis",
            temperature = "6.1"
        )
    }
}