package com.tomildev.weatdot.features.mainview.presentation

import androidx.annotation.StringRes
import com.tomildev.weatdot.core.domain.model.WeatherInfo

data class MainViewUiState(
    val weatherInfo: WeatherInfo? = null,
    val cityName: String = "City",
    val countryName: String = "Country",
    val isLoading: Boolean = false,
    val error: String? = null,
    @StringRes val statusMessageRes: Int? = null,
    val lastWeatherUpdate: Long? = null
)