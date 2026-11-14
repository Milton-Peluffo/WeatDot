package com.tomildev.weatdot.core.data.mapper

import com.tomildev.weatdot.core.data.dto.WeatherResponseDto
import com.tomildev.weatdot.core.data.local.database.entity.DailyWeatherEntity
import com.tomildev.weatdot.core.data.local.database.entity.HourlyWeatherEntity
import com.tomildev.weatdot.core.data.local.database.entity.WeatherEntity
import com.tomildev.weatdot.core.domain.model.CurrentWeather
import com.tomildev.weatdot.core.domain.model.DailyWeather
import com.tomildev.weatdot.core.domain.model.HourlyWeather
import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.model.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun WeatherResponseDto.toWeatherEntity(
    cityName: String,
    countryName: String
): WeatherEntity {
    val currentData = currentWeather
    val now = LocalDateTime.now()
    val today = now.toLocalDate()

    val hourlyList = hourlyWeather.time.indices.mapNotNull { index ->
        val rawTime = hourlyWeather.time[index]
        val dateTime = try {
            LocalDateTime.parse(rawTime, DateTimeFormatter.ISO_DATE_TIME)
        } catch (e: Exception) {
            null
        }

        if (dateTime != null && dateTime.toLocalDate() == today) {
            HourlyWeatherEntity(
                time = rawTime,
                temperature = hourlyWeather.temperature[index],
                weatherCode = hourlyWeather.weatherCode[index]
            )
        } else {
            null
        }
    }

    val dailyList = dailyWeather.time.indices.mapNotNull { index ->
        val rawDate = dailyWeather.time[index]
        val parsedDate = try {
            LocalDate.parse(rawDate, DateTimeFormatter.ISO_LOCAL_DATE)
        } catch (e: Exception) {
            null
        }

        if (parsedDate != null) {
            val dayName =
                parsedDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).uppercase()
            DailyWeatherEntity(
                date = rawDate,
                dayName = dayName,
                isToday = (parsedDate == today),
                minTemperature = dailyWeather.temperatureMin[index],
                maxTemperature = dailyWeather.temperatureMax[index],
                weatherCode = dailyWeather.weatherCode[index]
            )
        } else {
            null
        }
    }

    return WeatherEntity(
        id = 0,
        cityName = cityName,
        countryName = countryName,
        temperature = currentData.temperature,
        humidity = currentData.humidity,
        pressure = currentData.pressure,
        windSpeed = currentData.windSpeed,
        weatherCode = currentData.weatherCode,
        updatedAtTimestamp = System.currentTimeMillis(),
        hourlyForecast = hourlyList,
        dailyForecast = dailyList
    )
}

fun WeatherEntity.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        currentWeather = CurrentWeather(
            temperature = temperature,
            humidity = humidity,
            pressure = pressure,
            windSpeed = windSpeed,
            weatherType = WeatherType.fromWMO(weatherCode)
        ),
        hourlyForecast = hourlyForecast.map { entity ->
            HourlyWeather(
                time = entity.time,
                temperature = entity.temperature,
                weatherType = WeatherType.fromWMO(entity.weatherCode)
            )
        },
        dailyForecast = dailyForecast.map { entity ->
            DailyWeather(
                date = entity.date,
                dayName = entity.dayName,
                isToday = entity.isToday,
                minTemperature = entity.minTemperature,
                maxTemperature = entity.maxTemperature,
                weatherType = WeatherType.fromWMO(entity.weatherCode)
            )
        },
        updatedAtTimestamp = updatedAtTimestamp
    )
}