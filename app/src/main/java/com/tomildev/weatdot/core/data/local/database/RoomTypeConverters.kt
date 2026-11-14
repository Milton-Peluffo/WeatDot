package com.tomildev.weatdot.core.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tomildev.weatdot.core.data.local.database.entity.DailyWeatherEntity
import com.tomildev.weatdot.core.data.local.database.entity.HourlyWeatherEntity
import com.tomildev.weatdot.core.domain.model.HourlyWeather

class RoomTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromHourlyWeatherList(value: List<HourlyWeatherEntity>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toHourlyWeatherList(value: String): List<HourlyWeatherEntity> {
        val type = object : TypeToken<List<HourlyWeatherEntity>>() {}.type
        return gson.fromJson(value, type) ?: emptyList()
    }

    @TypeConverter
    fun fromDailyWeatherList(value: List<DailyWeatherEntity>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toDailyWeatherList(value: String): List<DailyWeatherEntity> {
        val type = object : TypeToken<List<DailyWeatherEntity>>() {}.type
        return gson.fromJson(value, type) ?: emptyList()
    }
}