package com.tomildev.weathy.core.data.mapper

import com.tomildev.weathy.core.data.dto.WeatherResponseDto
import com.tomildev.weathy.core.domain.model.CurrentWeather
import com.tomildev.weathy.core.domain.model.HourlyWeather
import com.tomildev.weathy.core.domain.model.WeatherInfo
import com.tomildev.weathy.core.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun WeatherResponseDto.toWeatherInfo(): WeatherInfo {
    val currentData = this.currentWeather

    val now = LocalDateTime.now()
    val today = now.toLocalDate()

    // Filtramos para incluir TODAS las 24 horas del día de hoy (desde las 00:00 hasta las 23:00)
    val hourlyList = this.hourlyWeather.time.indices.mapNotNull { index ->
        val rawTime = this.hourlyWeather.time[index]

        val dateTime = try {
            LocalDateTime.parse(rawTime, DateTimeFormatter.ISO_DATE_TIME)
        } catch (e: Exception) {
            null
        }

        // Filtro: Solo comprobamos que la fecha sea la de HOY
        if (dateTime != null && dateTime.toLocalDate() == today) {
            HourlyWeather(
                time = rawTime,
                temperature = this.hourlyWeather.temperature[index],
                weatherType = WeatherType.fromWMO(this.hourlyWeather.weatherCode[index])
            )
        } else {
            null
        }
    }

    return WeatherInfo(
        currentWeather = CurrentWeather(
            temperature = currentData.temperature,
            humidity = currentData.humidity,
            pressure = currentData.pressure,
            windSpeed = currentData.windSpeed,
            weatherType = WeatherType.fromWMO(currentData.weatherCode)
        ),
        hourlyForecast = hourlyList
    )
}