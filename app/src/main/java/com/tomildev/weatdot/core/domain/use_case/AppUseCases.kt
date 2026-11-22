package com.tomildev.weatdot.core.domain.use_case

import javax.inject.Inject

class AppUseCases @Inject constructor(
    val getWeatherFlowUseCase: GetWeatherFlowUseCase,
    val fetchWeatherUseCase: FetchWeatherUseCase,
    val getLocationUseCase: GetLocationUseCase,
    val getCityAndCountryUseCase: GetCityAndCountryUseCase,
    val getSavedLocationUseCase: GetSavedLocationUseCase,
    val saveLocationUseCase: SaveLocationUseCase
)