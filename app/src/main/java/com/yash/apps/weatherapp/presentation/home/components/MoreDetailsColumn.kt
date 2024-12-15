package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun MoreDetailsColumn(modifier: Modifier = Modifier, label: String, value: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = Color(0xFFC4C4C4),
            textAlign = TextAlign.Center
        )
        Text(
            text = value,
            fontSize = 15.sp,
            lineHeight = 22.5.sp,
            color = Color(0xFF9A9A9A),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoreDetailsColumnPreview() {
    WeatherAppTheme {
        MoreDetailsColumn(label = "Humidity", value = "20%")
    }
}