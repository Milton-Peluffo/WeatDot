package com.tomildev.weatdot.core.data.repository

import com.tomildev.weatdot.core.data.dao.WeatherDao
import com.tomildev.weatdot.core.data.mapper.toWeatherEntity
import com.tomildev.weatdot.core.data.mapper.toWeatherInfo
import com.tomildev.weatdot.core.data.remote.WeatherApi
import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val dao: WeatherDao
) : WeatherRepository {

    override fun getWeatherFlow(): Flow<WeatherInfo?> {
        return dao.getWeatherFlow().map { entity ->
            entity?.toWeatherInfo()
        }
    }

    override suspend fun fetchAndCacheWeather(
        lat: Double,
        long: Double,
        cityName: String,
        countryName: String
    ): Result<Unit> {
        return try {
            val responseDto = api.getWeatherData(latitude = lat, longitude = long)
            val entity = responseDto.toWeatherEntity(cityName = cityName, countryName = countryName)
            dao.upsertWeather(entity)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}