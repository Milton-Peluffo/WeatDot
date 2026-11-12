package com.tomildev.weatdot.core.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey
    val id: Int = 0,
    val cityName: String,
    val countryName: String,
    val temperature: Double,
    val humidity: Double,
    val pressure: Double,
    val windSpeed: Double,
    val weatherCode: Int,
    val updatedAtTimestamp: Long,
    val hourlyForecast: List<HourlyWeatherEntity>,
    val dailyForecast: List<DailyWeatherEntity>
)