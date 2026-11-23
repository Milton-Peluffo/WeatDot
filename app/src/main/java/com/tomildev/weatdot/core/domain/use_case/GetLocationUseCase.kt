package com.tomildev.weatdot.core.domain.use_case

import android.location.Location
import com.tomildev.weatdot.core.domain.location.LocationTracker
import javax.inject.Inject

/**
 * Use case responsible for obtaining the device's current physical GPS location.
 */
class GetLocationUseCase @Inject constructor(
    private val locationTracker: LocationTracker
) {
    /**
     * Retrieves the current device location asynchronously.
     *
     * @return The device [Location] if permissions and GPS services are active, or `null` otherwise.
     */
    suspend operator fun invoke(): Location? {
        return locationTracker.getCurrentLocation()
    }
}