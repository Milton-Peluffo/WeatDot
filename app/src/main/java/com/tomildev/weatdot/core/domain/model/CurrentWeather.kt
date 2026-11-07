package com.tomildev.weatdot.core.domain.model

/**
Clase de datos que representa el modelo de dominio del clima actual
 */
data class CurrentWeather(
    val temperature: Double,
    val weatherType: WeatherType,
    val humidity: Double,
    val windSpeed: Double,
    val pressure: Double,
)