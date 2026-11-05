package com.tomildev.weathy.core.domain.use_case

import com.tomildev.weathy.core.domain.model.WeatherInfo
import com.tomildev.weathy.core.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, long: Double): Result<WeatherInfo> {
        return weatherRepository.getWeatherData(lat, long)
    }
}