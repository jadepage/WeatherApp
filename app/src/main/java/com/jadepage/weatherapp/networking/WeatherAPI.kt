package com.jadepage.weatherapp.networking

import retrofit2.Call
import retrofit2.http.GET

interface WeatherAPI {

    @GET("/")
    fun getCurrentWeather(): Call<CurrentWeatherList>
    fun getTimeZone(): Call<TimeZone>

}