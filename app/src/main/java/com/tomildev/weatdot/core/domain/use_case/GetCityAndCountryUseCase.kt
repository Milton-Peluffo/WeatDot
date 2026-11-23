package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import javax.inject.Inject

/**
 * Use case responsible for resolving coordinates into readable city and country names.
 */
class GetCityAndCountryUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    /**
     * Performs reverse geocoding lookup via REST API.
     *
     * @param latitude Geographic latitude.
     * @param longitude Geographic longitude.
     * @param language System ISO language code (e.g., "es", "en") for localized names.
     * @return Resolved [UserLocation] domain object.
     */
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
        language: String
    ): UserLocation {
        return repository.getCityAndCountry(latitude, longitude, language)
    }
}