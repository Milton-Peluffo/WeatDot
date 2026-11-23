package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case responsible for observing continuously updated weather data stored in local storage.
 */
class GetWeatherFlowUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    /**
     * Observes current cached weather info from Room database.
     *
     * @return A [Flow] emitting the latest [WeatherInfo] or `null` if no cache exists.
     */
    operator fun invoke(): Flow<WeatherInfo?> {
        return repository.getWeatherFlow()
    }
}