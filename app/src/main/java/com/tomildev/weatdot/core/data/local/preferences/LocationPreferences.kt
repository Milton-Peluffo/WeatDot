package com.tomildev.weatdot.core.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "location_preferences")

data class SavedLocation(
    val latitude: Double,
    val longitude: Double,
    val cityName: String,
    val countryName: String
)

@Singleton
class LocationPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private object Keys {
        val LATITUDE = doublePreferencesKey("last_latitude")
        val LONGITUDE = doublePreferencesKey("last_longitude")
        val CITY_NAME = stringPreferencesKey("last_city_name")
        val COUNTRY_NAME = stringPreferencesKey("last_country_name")
    }

    val savedLocationFlow: Flow<SavedLocation> = context.dataStore.data.map { preferences ->
        SavedLocation(
            latitude = preferences[Keys.LATITUDE] ?: 51.5074,
            longitude = preferences[Keys.LONGITUDE] ?: -0.1278,
            cityName = preferences[Keys.CITY_NAME] ?: "London",
            countryName = preferences[Keys.COUNTRY_NAME] ?: "United Kingdom"
        )
    }

    suspend fun saveLocation(latitude: Double, longitude: Double, cityName: String, countryName: String) {
        context.dataStore.edit { preferences ->
            preferences[Keys.LATITUDE] = latitude
            preferences[Keys.LONGITUDE] = longitude
            preferences[Keys.CITY_NAME] = cityName
            preferences[Keys.COUNTRY_NAME] = countryName
        }
    }
}