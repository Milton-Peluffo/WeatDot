package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import javax.inject.Inject

class FetchWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(
        lat: Double,
        long: Double,
        cityName: String,
        countryName: String
    ): Result<Unit> {
        return repository.fetchAndCacheWeather(lat, long, cityName, countryName)
    }
}