package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun MoreDetailsSection(
    modifier: Modifier = Modifier,
    humidity: String,
    uvIndex: String,
    feelsLike: String
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color(0xFFF2F2F2))
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoreDetailsColumn(label = "Humidity", value = humidity)
        MoreDetailsColumn(label = "UV", value = uvIndex)
        MoreDetailsColumn(label = "Feels Like", value = feelsLike)
    }
}

@Preview
@Composable
private fun MoreDetailsSectionPreview() {
    WeatherAppTheme {
        MoreDetailsSection(humidity = "20%", uvIndex = "4", feelsLike = "38°")
    }
}