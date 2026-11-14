package com.tomildev.weatdot.core.data.local.database.entity

data class HourlyWeatherEntity(
    val time: String,
    val temperature: Double,
    val weatherCode: Int
)