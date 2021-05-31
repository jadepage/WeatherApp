package com.jadepage.weatherapp.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


// Current Weather

@JsonClass(generateAdapter = true)
data class CurrentWeatherList(
        @Json(name = "hourly") val items: List<CurrentWeather>
)

@JsonClass(generateAdapter = true)
data class CurrentWeather(
        @Json(name = "dt") val time: Int,
        @Json(name= "temp") val temp: Double,
        @Json(name="description") val description: String
)


@JsonClass(generateAdapter = true)
data class TimeZone(
        @Json(name="timezone") val weather: String
)



