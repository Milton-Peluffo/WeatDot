package com.tomildev.weatdot.core.domain.repository

import com.tomildev.weatdot.core.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo>
}