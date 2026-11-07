package com.tomildev.weatdot.core.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.tomildev.weatdot.R
import com.tomildev.weatdot.ui.theme.WeatDotDrawables

sealed class WeatherType(
    @StringRes val weatherDescRes: Int,
    @DrawableRes val iconRes: Int,
    @RawRes val backgroundRes: Int
) {
    object ClearSky : WeatherType(
        weatherDescRes = R.string.weather_code_description_clear_sky,
        iconRes = WeatDotDrawables.Icons.ClearSky,
        backgroundRes = WeatDotDrawables.Backgrounds.ClearSky
    )

    object MainlyClear : WeatherType(
        weatherDescRes = R.string.weather_code_description_mainly_clear,
        iconRes = WeatDotDrawables.Icons.MainlyClear,
        backgroundRes = WeatDotDrawables.Backgrounds.MainlyClear
    )

    object PartlyCloudy : WeatherType(
        weatherDescRes = R.string.weather_code_description_partly_cloudy,
        iconRes = WeatDotDrawables.Icons.PartlyCloudy,
        backgroundRes = WeatDotDrawables.Backgrounds.PartlyCloudy
    )

    object Overcast : WeatherType(
        weatherDescRes = R.string.weather_code_description_overcast,
        iconRes = WeatDotDrawables.Icons.Overcast,
        backgroundRes = WeatDotDrawables.Backgrounds.Overcast
    )

    object Fog : WeatherType(
        weatherDescRes = R.string.weather_code_description_fog,
        iconRes = WeatDotDrawables.Icons.Fog,
        backgroundRes = WeatDotDrawables.Backgrounds.Fog
    )

    object DepositingRimeFog : WeatherType(
        weatherDescRes = R.string.weather_code_description_depositing_rime_fog,
        iconRes = WeatDotDrawables.Icons.DepositingRimeFog,
        backgroundRes = WeatDotDrawables.Backgrounds.DepositingRimeFog
    )

    object LightDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_drizzle,
        iconRes = WeatDotDrawables.Icons.LightDrizzle,
        backgroundRes = WeatDotDrawables.Backgrounds.LightDrizzle
    )

    object ModerateDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_drizzle,
        iconRes = WeatDotDrawables.Icons.ModerateDrizzle,
        backgroundRes = WeatDotDrawables.Backgrounds.ModerateDrizzle
    )

    object DenseDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_drizzle,
        iconRes = WeatDotDrawables.Icons.DenseDrizzle,
        backgroundRes = WeatDotDrawables.Backgrounds.DenseDrizzle
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_drizzle,
        iconRes = WeatDotDrawables.Icons.LightFreezingDrizzle,
        backgroundRes = WeatDotDrawables.Backgrounds.LightFreezingDrizzle
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_freezing_drizzle,
        iconRes = WeatDotDrawables.Icons.DenseFreezingDrizzle,
        backgroundRes = WeatDotDrawables.Backgrounds.DenseFreezingDrizzle
    )

    object SlightRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain,
        iconRes = WeatDotDrawables.Icons.SlightRain,
        backgroundRes = WeatDotDrawables.Backgrounds.SlightRain
    )

    object ModerateRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain,
        iconRes = WeatDotDrawables.Icons.ModerateRain,
        backgroundRes = WeatDotDrawables.Backgrounds.ModerateRain
    )

    object HeavyRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_rain,
        iconRes = WeatDotDrawables.Icons.HeavyRain,
        backgroundRes = WeatDotDrawables.Backgrounds.HeavyRain
    )

    object LightFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_rain,
        iconRes = WeatDotDrawables.Icons.LightFreezingRain,
        backgroundRes = WeatDotDrawables.Backgrounds.LightFreezingRain
    )

    object HeavyFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_freezing_rain,
        iconRes = WeatDotDrawables.Icons.HeavyFreezingRain,
        backgroundRes = WeatDotDrawables.Backgrounds.HeavyFreezingRain
    )

    object SlightSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snowfall,
        iconRes = WeatDotDrawables.Icons.SlightSnowfall,
        backgroundRes = WeatDotDrawables.Backgrounds.SlightSnowfall
    )

    object ModerateSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_snowfall,
        iconRes = WeatDotDrawables.Icons.ModerateSnowfall,
        backgroundRes = WeatDotDrawables.Backgrounds.ModerateSnowfall
    )

    object HeavySnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snowfall,
        iconRes = WeatDotDrawables.Icons.HeavySnowfall,
        backgroundRes = WeatDotDrawables.Backgrounds.HeavySnowfall
    )

    object SnowGrains : WeatherType(
        weatherDescRes = R.string.weather_code_description_snow_grains,
        iconRes = WeatDotDrawables.Icons.SnowGrains,
        backgroundRes = WeatDotDrawables.Backgrounds.SnowGrains
    )

    object SlightRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain_showers,
        iconRes = WeatDotDrawables.Icons.SlightRainShowers,
        backgroundRes = WeatDotDrawables.Backgrounds.SlightRainShowers
    )

    object ModerateRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain_showers,
        iconRes = WeatDotDrawables.Icons.ModerateRainShowers,
        backgroundRes = WeatDotDrawables.Backgrounds.ModerateRainShowers
    )

    object ViolentRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_violent_rain_showers,
        iconRes = WeatDotDrawables.Icons.ViolentRainShowers,
        backgroundRes = WeatDotDrawables.Backgrounds.ViolentRainShowers
    )

    object SlightSnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snow_showers,
        iconRes = WeatDotDrawables.Icons.SlightSnowShowers,
        backgroundRes = WeatDotDrawables.Backgrounds.SlightSnowShowers
    )

    object HeavySnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snow_showers,
        iconRes = WeatDotDrawables.Icons.HeavySnowShowers,
        backgroundRes = WeatDotDrawables.Backgrounds.HeavySnowShowers
    )

    object Thunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm,
        iconRes = WeatDotDrawables.Icons.Thunderstorm,
        backgroundRes = WeatDotDrawables.Backgrounds.Thunderstorm
    )

    object ThunderstormWithSlightHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_slight_hail,
        iconRes = WeatDotDrawables.Icons.ThunderstormWithSlightHail,
        backgroundRes = WeatDotDrawables.Backgrounds.ThunderstormWithSlightHail
    )

    object HeavyThunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_thunderstorm,
        iconRes = WeatDotDrawables.Icons.HeavyThunderstorm,
        backgroundRes = WeatDotDrawables.Backgrounds.HeavyThunderstorm
    )

    object ThunderstormWithHeavyHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_heavy_hail,
        iconRes = WeatDotDrawables.Icons.ThunderstormWithHeavyHail,
        backgroundRes = WeatDotDrawables.Backgrounds.ThunderstormWithHeavyHail
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Fog
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingRain
                67 -> HeavyFreezingRain
                71 -> SlightSnowfall
                73 -> ModerateSnowfall
                75 -> HeavySnowfall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> Thunderstorm
                96 -> ThunderstormWithSlightHail
                97 -> HeavyThunderstorm
                99 -> ThunderstormWithHeavyHail
                else -> ClearSky
            }
        }
    }
}