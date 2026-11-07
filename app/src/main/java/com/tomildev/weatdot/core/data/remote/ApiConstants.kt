package com.tomildev.weatdot.core.data.remote

object ApiConstants {
    const val BASE_URL = "https://api.open-meteo.com/"
    const val DEFAULT_CURRENT = "temperature_2m,relative_humidity_2m,surface_pressure,wind_speed_10m,weather_code"
    const val DEFAULT_HOURLY = "temperature_2m,weather_code"
    const val DEFAULT_DAILY = "weather_code,temperature_2m_max,temperature_2m_min"
    const val DEFAULT_TIMEZONE = "auto"

    const val GEO_CODING_BASE_URL = "https://api.bigdatacloud.net/"
}