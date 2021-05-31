package com.jadepage.weatherapp.networking

import android.util.Log
import com.jadepage.weatherapp.models.WeatherModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object Network {

    private val items = mutableListOf<WeatherModel>()

    private val client = OkHttpClient()

    private val weatherAPI: WeatherAPI
        get() {
            return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org" +
                    "/data/2.5/onecall/timemachine?lat=60.99&" +
                    "lon=30.9&dt=1586468027&" +
                    "appid=76cdcd7eac59a94f8e04f59e177e3c2e"
                )
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(WeatherAPI::class.java)
        }

    fun getWeather(onSuccess: (List<WeatherModel>) -> Unit) {
        if(items.isEmpty()) {
            onSuccess(items)
        }
        weatherAPI.getCurrentWeather().enqueue(object : Callback<CurrentWeatherList>{
            override fun onResponse(call: Call<CurrentWeatherList>, response: Response<CurrentWeatherList>) {
                val currentWeather = response.body()?.items?.map { it.covert() } ?: emptyList()
                items.clear()
                items.addAll(currentWeather)
                onSuccess(items)
            }

            override fun onFailure(call: Call<CurrentWeatherList>, t: Throwable) {
                Log.v("Networking", "Error! $t")
            }
        })
    }
    private fun CurrentWeather.covert(): WeatherModel {
        return WeatherModel(
            weather_time = time,
            weather_description = description,
            weather_temp = temp
        )
    }
}