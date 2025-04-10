package com.kinery.weather.data.network

import com.kinery.weather.data.model.WeatherResponse
import com.kinery.weather.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String = "imperial",
        @Query("appid") apiKey: String = Constants.API_KEY,
    ): WeatherResponse
}
