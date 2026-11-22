package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.data.local.preferences.LocationPreferences
import com.tomildev.weatdot.core.data.local.preferences.SavedLocation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedLocationUseCase @Inject constructor(
    private val locationPreferences: LocationPreferences
) {
    operator fun invoke(): Flow<SavedLocation> {
        return locationPreferences.savedLocationFlow
    }
}