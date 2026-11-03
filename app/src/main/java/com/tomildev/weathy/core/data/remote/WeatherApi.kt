package com.tomildev.weathy.core.data.remote

import com.tomildev.weathy.core.data.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = ApiConstants.DEFAULT_CURRENT,
        @Query("hourly") hourly: String = ApiConstants.DEFAULT_HOURLY,
        @Query("daily") daily: String = ApiConstants.DEFAULT_DAILY,
        @Query("timezone") timezone: String = ApiConstants.DEFAULT_TIMEZONE
    ): WeatherResponseDto
}