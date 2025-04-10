package com.kinery.weather.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kinery.weather.data.model.WeatherResponse
import com.kinery.weather.data.network.NetworkClient
import com.kinery.weather.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = WeatherRepository(NetworkClient.provideWeatherApi())

    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val weather = repository.getCurrentWeather(city)
                _weatherState.value = weather
            } catch (e: Exception) {
                //TODO: Handle error (e.g., show a message in the UI)
                e.printStackTrace()
            }
        }
    }
}