package com.tomildev.weatdot.core.di

import android.app.Application
import androidx.room.Room
import com.tomildev.weatdot.core.data.dao.WeatherDao
import com.tomildev.weatdot.core.data.local.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideWeatherDatabase(
        application: Application
    ): WeatherDatabase {
        return Room.databaseBuilder(
            application,
            WeatherDatabase::class.java,
            "weatdot_database.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWeatherDao(
        database: WeatherDatabase
    ): WeatherDao {
        return database.weatherDao
    }
}