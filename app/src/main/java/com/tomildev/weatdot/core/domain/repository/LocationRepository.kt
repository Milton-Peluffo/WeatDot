package com.tomildev.weatdot.core.domain.repository

import com.tomildev.weatdot.core.domain.model.UserLocation
import kotlinx.coroutines.flow.Flow

/**
 * Domain repository interface for managing location data.
 *
 * Defines the contract for observing saved user locations, persisting updated coordinates,
 * and performing reverse geocoding lookups without exposing data-layer implementation details.
 */
interface LocationRepository {
    /**
     * Observes the continuously updated saved location stored in local preferences.
     *
     * @return A [Flow] emitting the current [UserLocation].
     */
    fun getSavedLocationFlow(): Flow<UserLocation>

    /**
     * Persists the given [UserLocation] to local preferences.
     *
     * @param location The [UserLocation] instance to be saved.
     */
    suspend fun saveLocation(location: UserLocation)

    /**
     * Performs a reverse geocoding lookup for the given coordinates.
     *
     * @param latitude Geographic latitude.
     * @param longitude Geographic longitude.
     * @param language ISO language code (e.g., "es", "en") for localized city and country names.
     * @return A [UserLocation] containing the resolved city and country names.
     */
    suspend fun getCityAndCountry(
        latitude: Double,
        longitude: Double,
        language: String
    ): UserLocation
}