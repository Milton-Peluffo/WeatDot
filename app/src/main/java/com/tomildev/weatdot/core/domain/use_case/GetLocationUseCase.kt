package com.tomildev.weatdot.core.domain.use_case

import android.location.Location
import com.tomildev.weatdot.core.domain.location.LocationTracker
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationTracker: LocationTracker
) {
    suspend operator fun invoke(): Location? {
        return locationTracker.getCurrentLocation()
    }
}