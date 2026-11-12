package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherFlowUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(): Flow<WeatherInfo?> {
        return repository.getWeatherFlow()
    }
}