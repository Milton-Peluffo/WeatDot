package com.tomildev.weathy.core.domain.use_case

import javax.inject.Inject

class WeathyUseCases @Inject constructor(
    val getWeatherDataUseCase: GetWeatherDataUseCase
)