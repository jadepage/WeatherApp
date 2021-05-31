package com.jadepage.weatherapp.models

import androidx.annotation.DrawableRes

data class WeatherModel(
    val weather_type: String,
    val weather_time: String,
    @DrawableRes val weather_icon: Int,
    val weather_temp: String
)