package com.tomildev.weathy.core.domain.model

data class HourlyWeather(
    val time: String,
    val temperature: Double,
    val weatherType: WeatherType
)