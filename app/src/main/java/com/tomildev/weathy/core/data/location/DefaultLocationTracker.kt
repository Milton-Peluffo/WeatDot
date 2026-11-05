package com.tomildev.weathy.core.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.tomildev.weathy.core.domain.location.LocationTracker
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Default implementation of [LocationTracker] that retrieves the device's current location
 * using Google Play Services' [FusedLocationProviderClient].
 *
 * Key features:
 * - Verifies runtime permissions for fine and coarse location access.
 * - Checks whether GPS or Network location providers are enabled on the device.
 * - Fetches location using coroutines with [await] for non-blocking asynchronous execution.
 * - Uses [Priority.PRIORITY_BALANCED_POWER_ACCURACY] to minimize battery consumption.
 *
 * @property locationClient Google's location client used to access device sensors.
 * @property application Application context used to check system services and permissions safely.
 */

class DefaultLocationTracker @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationTracker {

    /**
     * Asynchronously retrieves the current device [Location].
     *
     * @return The current device [Location] if location permissions are granted and
     * GPS/Network is enabled; `null` otherwise or if retrieval fails.
     */

    override suspend fun getCurrentLocation(): Location? {
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            this.application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            this.application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager =
            this.application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled) {
            return null
        }

        return try {
            this.locationClient.getCurrentLocation(
                Priority.PRIORITY_BALANCED_POWER_ACCURACY,
                null
            ).await()
        } catch (e: Exception) {
            null
        }
    }
}