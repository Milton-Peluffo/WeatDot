package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.data.local.preferences.LocationPreferences
import javax.inject.Inject

class SaveLocationUseCase @Inject constructor(
    private val locationPreferences: LocationPreferences
) {
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
        cityName: String,
        countryName: String
    ) {
        locationPreferences.saveLocation(latitude, longitude, cityName, countryName)
    }
}