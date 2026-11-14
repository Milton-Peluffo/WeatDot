package com.tomildev.weatdot.core.domain.repository

import com.tomildev.weatdot.core.domain.model.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherFlow(): Flow<WeatherInfo?>

    suspend fun fetchAndCacheWeather(
        lat: Double,
        long: Double,
        cityName: String,
        countryName: String
    ): Result<Unit>
}