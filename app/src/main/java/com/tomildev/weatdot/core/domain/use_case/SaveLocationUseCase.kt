package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.repository.LocationRepository
import javax.inject.Inject

class SaveLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(location: UserLocation) {
        repository.saveLocation(location)
    }
}