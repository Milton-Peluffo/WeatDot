package com.tomildev.weatdot.core.domain.use_case

import javax.inject.Inject

class AppUseCases @Inject constructor(
    val getWeatherFlowUseCase: GetWeatherFlowUseCase,
    val fetchWeatherUseCase: FetchWeatherUseCase
)