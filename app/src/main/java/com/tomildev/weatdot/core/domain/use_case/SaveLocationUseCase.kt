package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import javax.inject.Inject

/**
 * Use case responsible for persisting updated location settings to DataStore preferences.
 */
class SaveLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    /**
     * Persists the given [UserLocation] to local preferences.
     *
     * @param location The [UserLocation] instance to be saved.
     */
    suspend operator fun invoke(location: UserLocation) {
        repository.saveLocation(location)
    }
}