package com.tomildev.weatdot.core.domain.use_case

import javax.inject.Inject

class WeatDotUseCases @Inject constructor(
    val getWeatherDataUseCase: GetWeatherDataUseCase
)