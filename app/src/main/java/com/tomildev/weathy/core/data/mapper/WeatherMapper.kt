package com.tomildev.weathy.core.data.mapper

import com.tomildev.weathy.core.data.dto.WeatherResponseDto
import com.tomildev.weathy.core.domain.model.CurrentWeather
import com.tomildev.weathy.core.domain.model.DailyWeather
import com.tomildev.weathy.core.domain.model.HourlyWeather
import com.tomildev.weathy.core.domain.model.WeatherInfo
import com.tomildev.weathy.core.domain.model.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

/**
Función de extensión para convertir un objeto WeatherResponseDto en un objeto WeatherInfo.
 */
fun WeatherResponseDto.toWeatherInfo(): WeatherInfo {
    val currentData = this.currentWeather

    val now = LocalDateTime.now()
    val today = now.toLocalDate()

    val hourlyList = this.hourlyWeather.time.indices.mapNotNull { index ->
        val rawTime = this.hourlyWeather.time[index]

        val dateTime = try {
            LocalDateTime.parse(rawTime, DateTimeFormatter.ISO_DATE_TIME)
        } catch (e: Exception) {
            null
        }

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

    val dailyList = this.dailyWeather.time.indices.mapNotNull { index ->
        val rawDate = this.dailyWeather.time[index]

        val parsedDate = try {
            LocalDate.parse(rawDate, DateTimeFormatter.ISO_LOCAL_DATE)
        } catch (e: Exception) {
            null
        }

        if (parsedDate != null) {
            val dayName = parsedDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).uppercase()

            DailyWeather(
                date = rawDate,
                dayName = dayName,
                isToday = (parsedDate == today),
                minTemperature = this.dailyWeather.temperatureMin[index],
                maxTemperature = this.dailyWeather.temperatureMax[index],
                weatherType = WeatherType.fromWMO(this.dailyWeather.weatherCode[index])
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
        hourlyForecast = hourlyList,
        dailyForecast = dailyList
    )
}