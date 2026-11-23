package com.tomildev.weatdot.core.data.repository

import com.tomildev.weatdot.core.data.local.preferences.LocationPreferences
import com.tomildev.weatdot.core.data.remote.GeocodingApi
import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Default implementation of [LocationRepository].
 *
 * Interacts with [GeocodingApi] for reverse geocoding network lookups
 * and [LocationPreferences] for Jetpack DataStore persistence.
 *
 * @property geocodingApi Retrofit API for reverse geocoding.
 * @property locationPreferences DataStore manager for location persistence.
 */
class LocationRepositoryImpl @Inject constructor(
    private val geocodingApi: GeocodingApi,
    private val locationPreferences: LocationPreferences
) : LocationRepository {
    override fun getSavedLocationFlow(): Flow<UserLocation> {
        return locationPreferences.savedLocationFlow.map { savedLocation ->
            UserLocation(
                latitude = savedLocation.latitude,
                longitude = savedLocation.longitude,
                cityName = savedLocation.cityName,
                countryName = savedLocation.countryName
            )
        }
    }

    override suspend fun saveLocation(location: UserLocation) {
        locationPreferences.saveLocation(
            latitude = location.latitude,
            longitude = location.longitude,
            cityName = location.cityName,
            countryName = location.countryName
        )
    }

    override suspend fun getCityAndCountry(
        latitude: Double,
        longitude: Double,
        language: String
    ): UserLocation {
        val dto = geocodingApi.getCityAndCountry(latitude, longitude, language)
        val cityName = dto.locality ?: dto.city ?: "Location"
        val countryName = dto.countryName ?: ""

        return UserLocation(
            latitude = latitude,
            longitude = longitude,
            cityName = cityName,
            countryName = countryName
        )
    }
}