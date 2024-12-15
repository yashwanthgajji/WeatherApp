package com.yash.apps.weatherapp.presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ResultCityComponent(
    modifier: Modifier = Modifier,
    location: String,
    temperature: String,
    condition: String,
    conditionIcon: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(Color(0xFFF2F2F2))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = location,
                style = MaterialTheme.typography.headlineSmall
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(text = temperature, style = MaterialTheme.typography.bodyLarge)
                Box(modifier = Modifier
                    .size(5.dp)
                    .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                )
            }
        }
        AsyncImage(
            modifier = Modifier.size(height = 67.dp, width = 83.dp),
            model = conditionIcon,
            contentDescription = condition,
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultCityComponentPreview() {
    WeatherAppTheme {
        ResultCityComponent(
            location = "Indianapolis",
            temperature = "6.1",
            condition = "Light rain",
            conditionIcon = "https://cdn.weatherapi.com/weather/64x64/night/296.png",
            onClick = {}
        )
    }
}