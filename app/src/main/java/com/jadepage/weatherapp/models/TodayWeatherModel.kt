package com.jadepage.weatherapp.models

import androidx.annotation.DrawableRes

data class TodayWeatherModel(
    var weather_time: String,
    @DrawableRes val weather_icon: Int,
    val weather_temp: String
)