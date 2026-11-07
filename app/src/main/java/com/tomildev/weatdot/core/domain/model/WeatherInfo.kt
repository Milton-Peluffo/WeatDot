package com.tomildev.weatdot.core.domain.model

/**
Clase de datos que representa la informacion proveniente de los modelos de dominio limpios
 */
data class WeatherInfo(
    val currentWeather: CurrentWeather?,
    val hourlyForecast: List<HourlyWeather> = emptyList(),
    val dailyForecast: List<DailyWeather> = emptyList()
)