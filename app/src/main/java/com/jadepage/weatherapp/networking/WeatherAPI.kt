package com.jadepage.weatherapp.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherAPI {

    @GET("onecall")
    fun getCurrentWeather(): Call<CurrentWeather>
}