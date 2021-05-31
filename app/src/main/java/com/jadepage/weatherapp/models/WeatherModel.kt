package com.jadepage.weatherapp.models

import androidx.annotation.DrawableRes

data class WeatherModel(
    val weather_description: String,
    val weather_time: Int,
//    @DrawableRes val weather_icon: Int,
    val weather_temp: Double
)