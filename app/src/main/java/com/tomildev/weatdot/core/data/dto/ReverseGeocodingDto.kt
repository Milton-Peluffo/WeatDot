package com.tomildev.weatdot.core.data.dto

import com.google.gson.annotations.SerializedName

data class ReverseGeocodingDto(
    @SerializedName("city")
    val city: String?,
    @SerializedName("locality")
    val locality: String?,
    @SerializedName("countryName")
    val countryName: String?
)