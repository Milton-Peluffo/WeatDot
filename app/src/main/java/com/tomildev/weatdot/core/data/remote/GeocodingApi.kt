package com.tomildev.weatdot.core.data.remote

import com.tomildev.weatdot.core.data.dto.ReverseGeocodingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("data/reverse-geocode-client")
    suspend fun getCityAndCountry(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("localityLanguage") language: String = "es"
    ): ReverseGeocodingDto
}