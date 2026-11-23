package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import javax.inject.Inject

class GetCityAndCountryUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
        language: String
    ): UserLocation {
        return repository.getCityAndCountry(latitude, longitude, language)
    }
}