package com.tomildev.weatdot.core.data.repository

import com.tomildev.weatdot.core.data.mapper.toWeatherInfo
import com.tomildev.weatdot.core.data.remote.WeatherApi
import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo> {
        return try {
            val responseDto = this.api.getWeatherData(
                latitude = lat,
                longitude = long
            )
            val weatherInfo = responseDto.toWeatherInfo()
            Result.success(weatherInfo)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}