package com.tomildev.weatdot.core.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("current")
    val currentWeather: CurrentWeatherDto,
    @SerializedName("hourly")
    val hourlyWeather: HourlyWeatherDto,
    @SerializedName("daily")
    val dailyWeather: DailyWeatherDto
)

data class CurrentWeatherDto(
    @SerializedName("temperature_2m")
    val temperature: Double,
    @SerializedName("relative_humidity_2m")
    val humidity: Double,
    @SerializedName("surface_pressure")
    val pressure: Double,
    @SerializedName("wind_speed_10m")
    val windSpeed: Double,
    @SerializedName("weather_code")
    val weatherCode: Int
)

data class HourlyWeatherDto(
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperature: List<Double>,
    @SerializedName("weather_code")
    val weatherCode: List<Int>
)

data class DailyWeatherDto(
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("temperature_2m_min")
    val temperatureMin: List<Double>,
    @SerializedName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerializedName("weather_code")
    val weatherCode: List<Int>
)

/*
  },
  "daily": {
    "time": [
      "2026-10-26",
      "2026-10-27",
      "2026-10-28",
      "2026-10-29",
      "2026-10-30",
      "2026-10-31",
      "2026-11-01"
    ],
    "weather_code": [95, 80, 80, 80, 80, 80, 95],
    "temperature_2m_max": [29.5, 29.6, 31.2, 30.7, 30.7, 30.9, 30.5],
    "temperature_2m_min": [26.2, 25.7, 24.9, 27, 26.3, 25.9, 26.3],
    "apparent_temperature_max": [34.8, 35.5, 37.5, 37.6, 36.8, 37.4, 37.3],
    "apparent_temperature_min": [31.8, 31.8, 30.6, 33, 33, 32.4, 32.3],
    "precipitation_sum": [27.9, 2.2, 2.8, 4, 2.4, 1.5, 9.3],
    "precipitation_hours": [17, 8, 3, 6, 9, 6, 15],
    "sunrise": [
      "2026-10-26T05:51",
      "2026-10-27T05:52",
      "2026-10-28T05:52",
      "2026-10-29T05:52",
      "2026-10-30T05:52",
      "2026-10-31T05:52",
      "2026-11-01T05:53"
    ],
 */