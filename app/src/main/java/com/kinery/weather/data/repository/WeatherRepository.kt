package com.kinery.weather.data.repository

import com.kinery.weather.data.model.WeatherResponse
import com.kinery.weather.data.network.WeatherApi

class WeatherRepository(private val api: WeatherApi) {

    suspend fun getCurrentWeather(city: String): WeatherResponse {
        return api.getCurrentWeather(city = city)
    }
}