package com.kinery.weather.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kinery.weather.R
import com.kinery.weather.ui.theme.WeatherTheme


@Composable
fun WeatherHomeScreen(
    modifier: Modifier,
) {

    //TODO: This call needs to be moved to main activity
    val viewModel: HomeViewModel = viewModel()
    val weather = viewModel.weatherState.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.fetchWeather("Minneapolis") //TODO: dynamic city from location
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherContent()
    }
}

@Composable
private fun WeatherContent() {
    Column {
        CurrentWeather()
    }
}

@Composable
private fun CurrentWeather() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Location
        Text(
            text = "Elk Rapids",
        )
        Icon(
            painter = painterResource(R.drawable.clear_sky_day_01),
            contentDescription = null //TODO: add content description
        )

        // Temp
        Text(
            text = "33°",
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // High
            Text(
                text = "H: 51°",
            )
            // Low
            Text(
                text = "L: 51°",
            )
        }
    }
}

@Preview
@Composable
private fun CurrentWeatherPreview() {
    WeatherTheme {
        CurrentWeather()
    }
}