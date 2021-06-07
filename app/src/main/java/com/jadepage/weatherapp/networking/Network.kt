package com.jadepage.weatherapp.networking

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.jadepage.weatherapp.R
import com.jadepage.weatherapp.models.LocationModel
import com.jadepage.weatherapp.models.WeatherModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    private const val apiKey = "76cdcd7eac59a94f8e04f59e177e3c2e"
    private const val TAG = "NetworkCall"

    private val client = OkHttpClient()
    private var weatherModel : WeatherModel? = null
    private val locationModel : LocationModel? = null

    private val weatherAPI: WeatherAPI
        get() {
            return Retrofit.Builder()
                .baseUrl(
                        "https://api.openweathermap.org/data/2.5/onecall?lat=${locationModel?.latitude}&" +
                                "lon=${locationModel?.longitude}&exclude=alerts&appid={$apiKey}")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(WeatherAPI::class.java)
        }

    private class WeatherCallBack(
            private val onSuccess:
            (WeatherModel?) -> Unit
    ) : Callback<CurrentWeather>{
        override fun onResponse(
                call: Call<CurrentWeather>,
                response: Response<CurrentWeather>
        ) {
            weatherModel = response.body()?.covert()
            onSuccess(weatherModel)
        }

        override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
            Log.v("Networking", "Error! $t")
        }
    }

    fun getWeather(onSuccess: (WeatherModel?) -> Unit) {
        weatherAPI
                .getCurrentWeather()
                .enqueue(WeatherCallBack(onSuccess))
    }
    private fun CurrentWeather.covert(): WeatherModel {
        return WeatherModel(
            weather_time = time,
            weather_description = weather?.description,
            weather_temp = temp
        )
    }
}