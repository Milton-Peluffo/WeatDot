package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case responsible for observing persisted location settings from DataStore preferences.
 */
class GetSavedLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    /**
     * Observes saved location preference changes.
     *
     * @return A [Flow] emitting current [UserLocation] preference.
     */
    operator fun invoke(): Flow<UserLocation> {
        return repository.getSavedLocationFlow()
    }
}