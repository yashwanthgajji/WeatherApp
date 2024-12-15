package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun TemperatureDisplay(modifier: Modifier = Modifier, temperature: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.Top) {
        Text(
            text = temperature,
            fontSize = 70.sp,
            textAlign = TextAlign.Center
        )
        Box(modifier = Modifier
            .size(8.dp)
            .border(width = 1.5.dp, color = Color.Black, shape = CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TemperatureDisplayPreview() {
    WeatherAppTheme {
        TemperatureDisplay(temperature = "25")
    }
}