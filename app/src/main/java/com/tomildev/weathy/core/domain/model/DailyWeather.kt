package com.tomildev.weathy.core.domain.model

data class DailyWeather(
    val date: String,
    val dayName: String,
    val minTemperature: Double,
    val maxTemperature: Double,
    val weatherType: WeatherType
)