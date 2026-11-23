package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import javax.inject.Inject

/**
 * Use case responsible for fetching fresh weather data from the remote API
 * and caching it into the local Room database.
 */
class FetchWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    /**
     * Executes weather data retrieval and local persistence.
     *
     * @param lat Geographic latitude coordinate.
     * @param long Geographic longitude coordinate.
     * @param cityName Name of the city.
     * @param countryName Name of the country.
     * @return [Result.success] if network fetch and local persistence succeeded; [Result.failure] otherwise.
     */
    suspend operator fun invoke(
        lat: Double,
        long: Double,
        cityName: String,
        countryName: String
    ): Result<Unit> {
        return repository.fetchAndCacheWeather(lat, long, cityName, countryName)
    }
}