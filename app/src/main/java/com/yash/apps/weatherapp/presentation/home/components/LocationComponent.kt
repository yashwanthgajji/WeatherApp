package com.yash.apps.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yash.apps.weatherapp.R
import com.yash.apps.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun LocationComponent(modifier: Modifier = Modifier, location: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = location, fontSize = 30.sp)
        Icon(
            modifier = Modifier.size(21.dp),
            painter = painterResource(id = R.drawable.location_icon),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationComponentPreview() {
    WeatherAppTheme {
        LocationComponent(location = "Hyderabad")
    }
}