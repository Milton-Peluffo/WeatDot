package com.tomildev.weatdot.core.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.tomildev.weatdot.R
import com.tomildev.weatdot.ui.theme.AppDrawables

sealed class WeatherType(
    @StringRes val weatherDescRes: Int,
    @DrawableRes val iconRes: Int,
    @RawRes val backgroundRes: Int
) {
    object ClearSky : WeatherType(
        weatherDescRes = R.string.weather_code_description_clear_sky,
        iconRes = AppDrawables.Icons.ClearSky,
        backgroundRes = AppDrawables.Backgrounds.ClearSky
    )

    object MainlyClear : WeatherType(
        weatherDescRes = R.string.weather_code_description_mainly_clear,
        iconRes = AppDrawables.Icons.MainlyClear,
        backgroundRes = AppDrawables.Backgrounds.MainlyClear
    )

    object PartlyCloudy : WeatherType(
        weatherDescRes = R.string.weather_code_description_partly_cloudy,
        iconRes = AppDrawables.Icons.PartlyCloudy,
        backgroundRes = AppDrawables.Backgrounds.PartlyCloudy
    )

    object Overcast : WeatherType(
        weatherDescRes = R.string.weather_code_description_overcast,
        iconRes = AppDrawables.Icons.Overcast,
        backgroundRes = AppDrawables.Backgrounds.Overcast
    )

    object Fog : WeatherType(
        weatherDescRes = R.string.weather_code_description_fog,
        iconRes = AppDrawables.Icons.Fog,
        backgroundRes = AppDrawables.Backgrounds.Fog
    )

    object DepositingRimeFog : WeatherType(
        weatherDescRes = R.string.weather_code_description_depositing_rime_fog,
        iconRes = AppDrawables.Icons.DepositingRimeFog,
        backgroundRes = AppDrawables.Backgrounds.DepositingRimeFog
    )

    object LightDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_drizzle,
        iconRes = AppDrawables.Icons.LightDrizzle,
        backgroundRes = AppDrawables.Backgrounds.LightDrizzle
    )

    object ModerateDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_drizzle,
        iconRes = AppDrawables.Icons.ModerateDrizzle,
        backgroundRes = AppDrawables.Backgrounds.ModerateDrizzle
    )

    object DenseDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_drizzle,
        iconRes = AppDrawables.Icons.DenseDrizzle,
        backgroundRes = AppDrawables.Backgrounds.DenseDrizzle
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_drizzle,
        iconRes = AppDrawables.Icons.LightFreezingDrizzle,
        backgroundRes = AppDrawables.Backgrounds.LightFreezingDrizzle
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_freezing_drizzle,
        iconRes = AppDrawables.Icons.DenseFreezingDrizzle,
        backgroundRes = AppDrawables.Backgrounds.DenseFreezingDrizzle
    )

    object SlightRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain,
        iconRes = AppDrawables.Icons.SlightRain,
        backgroundRes = AppDrawables.Backgrounds.SlightRain
    )

    object ModerateRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain,
        iconRes = AppDrawables.Icons.ModerateRain,
        backgroundRes = AppDrawables.Backgrounds.ModerateRain
    )

    object HeavyRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_rain,
        iconRes = AppDrawables.Icons.HeavyRain,
        backgroundRes = AppDrawables.Backgrounds.HeavyRain
    )

    object LightFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_rain,
        iconRes = AppDrawables.Icons.LightFreezingRain,
        backgroundRes = AppDrawables.Backgrounds.LightFreezingRain
    )

    object HeavyFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_freezing_rain,
        iconRes = AppDrawables.Icons.HeavyFreezingRain,
        backgroundRes = AppDrawables.Backgrounds.HeavyFreezingRain
    )

    object SlightSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snowfall,
        iconRes = AppDrawables.Icons.SlightSnowfall,
        backgroundRes = AppDrawables.Backgrounds.SlightSnowfall
    )

    object ModerateSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_snowfall,
        iconRes = AppDrawables.Icons.ModerateSnowfall,
        backgroundRes = AppDrawables.Backgrounds.ModerateSnowfall
    )

    object HeavySnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snowfall,
        iconRes = AppDrawables.Icons.HeavySnowfall,
        backgroundRes = AppDrawables.Backgrounds.HeavySnowfall
    )

    object SnowGrains : WeatherType(
        weatherDescRes = R.string.weather_code_description_snow_grains,
        iconRes = AppDrawables.Icons.SnowGrains,
        backgroundRes = AppDrawables.Backgrounds.SnowGrains
    )

    object SlightRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain_showers,
        iconRes = AppDrawables.Icons.SlightRainShowers,
        backgroundRes = AppDrawables.Backgrounds.SlightRainShowers
    )

    object ModerateRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain_showers,
        iconRes = AppDrawables.Icons.ModerateRainShowers,
        backgroundRes = AppDrawables.Backgrounds.ModerateRainShowers
    )

    object ViolentRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_violent_rain_showers,
        iconRes = AppDrawables.Icons.ViolentRainShowers,
        backgroundRes = AppDrawables.Backgrounds.ViolentRainShowers
    )

    object SlightSnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snow_showers,
        iconRes = AppDrawables.Icons.SlightSnowShowers,
        backgroundRes = AppDrawables.Backgrounds.SlightSnowShowers
    )

    object HeavySnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snow_showers,
        iconRes = AppDrawables.Icons.HeavySnowShowers,
        backgroundRes = AppDrawables.Backgrounds.HeavySnowShowers
    )

    object Thunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm,
        iconRes = AppDrawables.Icons.Thunderstorm,
        backgroundRes = AppDrawables.Backgrounds.Thunderstorm
    )

    object ThunderstormWithSlightHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_slight_hail,
        iconRes = AppDrawables.Icons.ThunderstormWithSlightHail,
        backgroundRes = AppDrawables.Backgrounds.ThunderstormWithSlightHail
    )

    object HeavyThunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_thunderstorm,
        iconRes = AppDrawables.Icons.HeavyThunderstorm,
        backgroundRes = AppDrawables.Backgrounds.HeavyThunderstorm
    )

    object ThunderstormWithHeavyHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_heavy_hail,
        iconRes = AppDrawables.Icons.ThunderstormWithHeavyHail,
        backgroundRes = AppDrawables.Backgrounds.ThunderstormWithHeavyHail
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