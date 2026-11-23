package com.tomildev.weatdot.core.domain.model

/**
 * Domain model representing a user's location.
 *
 * Encapsulates geographic coordinates along with city and country names,
 *
 * @property latitude Geographic latitude coordinate.
 * @property longitude Geographic longitude coordinate.
 * @property cityName Name of the city or locality.
 * @property countryName Name of the country.
 */
data class UserLocation(
    val latitude: Double,
    val longitude: Double,
    val cityName: String,
    val countryName: String
)