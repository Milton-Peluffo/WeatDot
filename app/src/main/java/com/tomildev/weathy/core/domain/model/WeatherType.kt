package com.tomildev.weathy.core.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.tomildev.weathy.R
import com.tomildev.weathy.ui.theme.WeathyDrawables

sealed class WeatherType(
    @StringRes val weatherDescRes: Int,
    @DrawableRes val iconRes: Int,
    @RawRes val backgroundRes: Int
) {
    object ClearSky : WeatherType(
        weatherDescRes = R.string.weather_code_description_clear_sky,
        iconRes = WeathyDrawables.Icons.ClearSky,
        backgroundRes = WeathyDrawables.Backgrounds.ClearSky
    )

    object MainlyClear : WeatherType(
        weatherDescRes = R.string.weather_code_description_mainly_clear,
        iconRes = WeathyDrawables.Icons.MainlyClear,
        backgroundRes = WeathyDrawables.Backgrounds.MainlyClear
    )

    object PartlyCloudy : WeatherType(
        weatherDescRes = R.string.weather_code_description_partly_cloudy,
        iconRes = WeathyDrawables.Icons.PartlyCloudy,
        backgroundRes = WeathyDrawables.Backgrounds.PartlyCloudy
    )

    object Overcast : WeatherType(
        weatherDescRes = R.string.weather_code_description_overcast,
        iconRes = WeathyDrawables.Icons.Overcast,
        backgroundRes = WeathyDrawables.Backgrounds.Overcast
    )

    object Fog : WeatherType(
        weatherDescRes = R.string.weather_code_description_fog,
        iconRes = WeathyDrawables.Icons.Fog,
        backgroundRes = WeathyDrawables.Backgrounds.Fog
    )

    object DepositingRimeFog : WeatherType(
        weatherDescRes = R.string.weather_code_description_depositing_rime_fog,
        iconRes = WeathyDrawables.Icons.DepositingRimeFog,
        backgroundRes = WeathyDrawables.Backgrounds.DepositingRimeFog
    )

    object LightDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_drizzle,
        iconRes = WeathyDrawables.Icons.LightDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.LightDrizzle
    )

    object ModerateDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_drizzle,
        iconRes = WeathyDrawables.Icons.ModerateDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateDrizzle
    )

    object DenseDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_drizzle,
        iconRes = WeathyDrawables.Icons.DenseDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.DenseDrizzle
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_drizzle,
        iconRes = WeathyDrawables.Icons.LightFreezingDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.LightFreezingDrizzle
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.weather_code_description_dense_freezing_drizzle,
        iconRes = WeathyDrawables.Icons.DenseFreezingDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.DenseFreezingDrizzle
    )

    object SlightRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain,
        iconRes = WeathyDrawables.Icons.SlightRain,
        backgroundRes = WeathyDrawables.Backgrounds.SlightRain
    )

    object ModerateRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain,
        iconRes = WeathyDrawables.Icons.ModerateRain,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateRain
    )

    object HeavyRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_rain,
        iconRes = WeathyDrawables.Icons.HeavyRain,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyRain
    )

    object LightFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_light_freezing_rain,
        iconRes = WeathyDrawables.Icons.LightFreezingRain,
        backgroundRes = WeathyDrawables.Backgrounds.LightFreezingRain
    )

    object HeavyFreezingRain : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_freezing_rain,
        iconRes = WeathyDrawables.Icons.HeavyFreezingRain,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyFreezingRain
    )

    object SlightSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snowfall,
        iconRes = WeathyDrawables.Icons.SlightSnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.SlightSnowfall
    )

    object ModerateSnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_snowfall,
        iconRes = WeathyDrawables.Icons.ModerateSnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateSnowfall
    )

    object HeavySnowfall : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snowfall,
        iconRes = WeathyDrawables.Icons.HeavySnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.HeavySnowfall
    )

    object SnowGrains : WeatherType(
        weatherDescRes = R.string.weather_code_description_snow_grains,
        iconRes = WeathyDrawables.Icons.SnowGrains,
        backgroundRes = WeathyDrawables.Backgrounds.SnowGrains
    )

    object SlightRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_rain_showers,
        iconRes = WeathyDrawables.Icons.SlightRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.SlightRainShowers
    )

    object ModerateRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_moderate_rain_showers,
        iconRes = WeathyDrawables.Icons.ModerateRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateRainShowers
    )

    object ViolentRainShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_violent_rain_showers,
        iconRes = WeathyDrawables.Icons.ViolentRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.ViolentRainShowers
    )

    object SlightSnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_slight_snow_showers,
        iconRes = WeathyDrawables.Icons.SlightSnowShowers,
        backgroundRes = WeathyDrawables.Backgrounds.SlightSnowShowers
    )

    object HeavySnowShowers : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_snow_showers,
        iconRes = WeathyDrawables.Icons.HeavySnowShowers,
        backgroundRes = WeathyDrawables.Backgrounds.HeavySnowShowers
    )

    object Thunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm,
        iconRes = WeathyDrawables.Icons.Thunderstorm,
        backgroundRes = WeathyDrawables.Backgrounds.Thunderstorm
    )

    object ThunderstormWithSlightHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_slight_hail,
        iconRes = WeathyDrawables.Icons.ThunderstormWithSlightHail,
        backgroundRes = WeathyDrawables.Backgrounds.ThunderstormWithSlightHail
    )

    object HeavyThunderstorm : WeatherType(
        weatherDescRes = R.string.weather_code_description_heavy_thunderstorm,
        iconRes = WeathyDrawables.Icons.HeavyThunderstorm,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyThunderstorm
    )

    object ThunderstormWithHeavyHail : WeatherType(
        weatherDescRes = R.string.weather_code_description_thunderstorm_with_heavy_hail,
        iconRes = WeathyDrawables.Icons.ThunderstormWithHeavyHail,
        backgroundRes = WeathyDrawables.Backgrounds.ThunderstormWithHeavyHail
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