package com.tomildev.weatdot.core.domain.use_case

import javax.inject.Inject

/**
 * Wrapper container class that encapsulates all domain use cases for the application.
 *
 * Simplifies dependency injection into ViewModels by providing a single point of entry
 * for all business logic operations.
 *
 * @property getWeatherFlowUseCase Observes cached weather data from local Room database.
 * @property fetchWeatherUseCase Triggers network weather data fetching and local persistence.
 * @property getLocationUseCase Retrieves current device GPS coordinates.
 * @property getCityAndCountryUseCase Performs reverse geocoding to resolve city/country names.
 * @property getSavedLocationUseCase Observes persisted user location from DataStore preferences.
 * @property saveLocationUseCase Persists updated user location to DataStore preferences.
 */
class AppUseCases @Inject constructor(
    val getWeatherFlowUseCase: GetWeatherFlowUseCase,
    val fetchWeatherUseCase: FetchWeatherUseCase,
    val getLocationUseCase: GetLocationUseCase,
    val getCityAndCountryUseCase: GetCityAndCountryUseCase,
    val getSavedLocationUseCase: GetSavedLocationUseCase,
    val saveLocationUseCase: SaveLocationUseCase
)