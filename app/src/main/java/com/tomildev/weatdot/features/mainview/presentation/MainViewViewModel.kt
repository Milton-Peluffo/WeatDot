package com.tomildev.weatdot.features.mainview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomildev.weatdot.core.data.local.preferences.LocationPreferences
import com.tomildev.weatdot.core.data.remote.GeocodingApi
import com.tomildev.weatdot.core.domain.location.LocationTracker
import com.tomildev.weatdot.core.domain.use_case.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val locationTracker: LocationTracker,
    private val locationPreferences: LocationPreferences,
    private val geocodingApi: GeocodingApi
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainViewUiState())
    val uiState = _uiState.asStateFlow()

    init {
        observeSavedLocationAndRoomCache()
        fetchCurrentGpsLocation()
    }

    private fun observeSavedLocationAndRoomCache() {
        viewModelScope.launch {
            locationPreferences.savedLocationFlow.collect { savedLocation ->
                _uiState.update {
                    it.copy(
                        cityName = savedLocation.cityName,
                        countryName = savedLocation.countryName,
                    )
                }
                refreshWeatherData(
                    lat = savedLocation.latitude,
                    long = savedLocation.longitude,
                    cityName = savedLocation.cityName,
                    countryName = savedLocation.countryName
                )
            }
        }

        viewModelScope.launch {
            appUseCases.getWeatherFlowUseCase().collect { weatherInfo ->

                _uiState.update {
                    it.copy(
                        weatherInfo = weatherInfo,
                        lastWeatherUpdate = weatherInfo?.updatedAtTimestamp,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun fetchCurrentGpsLocation() {
        viewModelScope.launch {
            val location = locationTracker.getCurrentLocation()
            if (location != null) {
                try {
                    val userLanguage = Locale.getDefault().language
                    val geoDto = geocodingApi.getCityAndCountry(
                        latitude = location.latitude,
                        longitude = location.longitude,
                        language = userLanguage
                    )
                    val cityName = geoDto.locality ?: geoDto.city ?: "Location"
                    val countryName = geoDto.countryName ?: ""

                    locationPreferences.saveLocation(
                        latitude = location.latitude,
                        longitude = location.longitude,
                        cityName = cityName,
                        countryName = countryName
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun refreshWeatherData(lat: Double, long: Double, cityName: String, countryName: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            val result = appUseCases.fetchWeatherUseCase(lat, long, cityName, countryName)
            result.onFailure { exception ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = exception.message ?: "Offline Mode"
                    )
                }
            }
        }
    }
}