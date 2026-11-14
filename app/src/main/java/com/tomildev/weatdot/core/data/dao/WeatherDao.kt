package com.tomildev.weatdot.core.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.tomildev.weatdot.core.data.local.database.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Upsert
    suspend fun upsertWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather_table WHERE id = 0")
    fun getWeatherFlow(): Flow<WeatherEntity?>

    @Query("DELETE FROM weather_table WHERE id = 0")
    suspend fun clearWeather()
}