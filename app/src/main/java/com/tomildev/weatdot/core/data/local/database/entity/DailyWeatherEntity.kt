package com.tomildev.weatdot.core.data.local.database.entity

data class DailyWeatherEntity(
    val date: String,
    val dayName: String,
    val isToday: Boolean,
    val minTemperature: Double,
    val maxTemperature: Double,
    val weatherCode: Int
)