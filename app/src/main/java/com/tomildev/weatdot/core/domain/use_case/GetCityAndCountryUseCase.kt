package com.tomildev.weatdot.core.domain.use_case

import com.tomildev.weatdot.core.data.dto.ReverseGeocodingDto
import com.tomildev.weatdot.core.data.remote.GeocodingApi
import javax.inject.Inject

class GetCityAndCountryUseCase @Inject constructor(
    private val geocodingApi: GeocodingApi
) {
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
        language: String
    ): ReverseGeocodingDto {
        return geocodingApi.getCityAndCountry(latitude, longitude, language)
    }
}