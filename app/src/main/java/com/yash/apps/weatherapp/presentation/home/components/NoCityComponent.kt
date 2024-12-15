package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun NoCityComponent(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "No City Selected",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Please Search For A City",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NoCityComponentPreview() {
    WeatherAppTheme {
        NoCityComponent()
    }
}