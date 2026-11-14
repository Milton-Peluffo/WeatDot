package com.tomildev.weatdot.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tomildev.weatdot.core.data.dao.WeatherDao
import com.tomildev.weatdot.core.data.local.database.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(RoomTypeConverters::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract val weatherDao: WeatherDao
}