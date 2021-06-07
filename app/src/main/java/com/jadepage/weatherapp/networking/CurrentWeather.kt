package com.jadepage.weatherapp.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Weather Item
@JsonClass(generateAdapter = true)
data class WeatherItem(
    @Json(name = "lat") val latitude:Double?,
    @Json(name= "lon") val longitude:Double?,
    @Json(name = "timezone") val timezone: String,
    @Json(name = "current") val currentWeather: CurrentWeather?,
    @Json(name= "hourly") val hourlyWeathers: List<HourlyWeatherItem>?,
    @Json(name= "daily") val dailyWeather: List<DailyWeatherItem>?
)

// Current Weather
@JsonClass(generateAdapter = true)
data class CurrentWeather(
        @Json(name= "dt") val time: Int?,
        @Json(name= "temp") val temp: Double?,
        @Json(name= "weather") val weather: WeatherSegment?
)

// Hourly Weather
@JsonClass(generateAdapter = true)
data class HourlyWeatherItem(
        @Json(name= "dt") val time: Long?,
        @Json(name= "temp") val temp: Double?,
        @Json(name= "weather") val weather: WeatherSegment?
)

// Daily Weather
@JsonClass(generateAdapter = true)
data class DailyWeatherItem(
        @Json(name= "dt") val time: Long?,
        @Json(name= "temp") val temp: String,
        @Json(name= "weather") val weather: WeatherSegment?
)

// Weather Segment for the weather description
@JsonClass(generateAdapter = true)
data class WeatherSegment(
        @Json(name= "description") val description: String?
)



