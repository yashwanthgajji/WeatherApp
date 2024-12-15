package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun NoCityComponent(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "No City Selected",
            fontSize = 30.sp,
            lineHeight = 45.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Please Search For A City",
            fontSize = 15.sp,
            lineHeight = 22.5.sp,
            textAlign = TextAlign.Center
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