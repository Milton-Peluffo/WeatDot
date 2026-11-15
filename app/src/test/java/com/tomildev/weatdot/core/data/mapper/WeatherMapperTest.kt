package com.tomildev.weatdot.core.data.mapper

import com.google.common.truth.Truth.assertThat
import com.tomildev.weatdot.core.data.dto.CurrentWeatherDto
import com.tomildev.weatdot.core.data.dto.DailyWeatherDto
import com.tomildev.weatdot.core.data.dto.HourlyWeatherDto
import com.tomildev.weatdot.core.data.dto.WeatherResponseDto
import com.tomildev.weatdot.core.data.local.database.entity.DailyWeatherEntity
import com.tomildev.weatdot.core.data.local.database.entity.HourlyWeatherEntity
import com.tomildev.weatdot.core.data.local.database.entity.WeatherEntity
import com.tomildev.weatdot.core.domain.model.WeatherType
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherMapperTest {

    @Test
    fun `toWeatherEntity maps DTO values to WeatherEntity correctly`() {
        // 1. ARRANGE
        val nowIso = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)

        val fakeDto = WeatherResponseDto(
            currentWeather = CurrentWeatherDto(
                temperature = 25.7,
                humidity = 80.0,
                pressure = 1013.0,
                windSpeed = 12.5,
                weatherCode = 45
            ),
            hourlyWeather = HourlyWeatherDto(
                time = listOf(nowIso),
                temperature = listOf(25.0),
                weatherCode = listOf(45)
            ),
            dailyWeather = DailyWeatherDto(
                time = listOf("2026-03-30"),
                temperatureMin = listOf(20.0),
                temperatureMax = listOf(30.0),
                weatherCode = listOf(45)
            )
        )

        // 2. ACT
        val entity = fakeDto.toWeatherEntity(
            cityName = "Bogotá",
            countryName = "Colombia"
        )

        // 3. ASSERT
        assertThat(entity.cityName).isEqualTo("Bogotá")
        assertThat(entity.countryName).isEqualTo("Colombia")
        assertThat(entity.temperature).isEqualTo(25.7)
        assertThat(entity.humidity).isEqualTo(80.0)
        assertThat(entity.weatherCode).isEqualTo(45)
        assertThat(entity.hourlyForecast).isNotEmpty()
        assertThat(entity.dailyForecast).isNotEmpty()
    }

    @Test
    fun `toWeatherInfo maps WeatherEntity to WeatherInfo domain model correctly`() {
        // 1. ARRANGE
        val fakeEntity = WeatherEntity(
            id = 0,
            cityName = "Madrid",
            countryName = "España",
            temperature = 22.0,
            humidity = 60.0,
            pressure = 1015.0,
            windSpeed = 8.5,
            weatherCode = 0,
            updatedAtTimestamp = 1711823400000L,
            hourlyForecast = listOf(
                HourlyWeatherEntity(
                    time = "2026-03-30T10:00",
                    temperature = 21.0,
                    weatherCode = 0
                )
            ),
            dailyForecast = listOf(
                DailyWeatherEntity(
                    date = "2026-03-30",
                    dayName = "TODAY",
                    isToday = true,
                    minTemperature = 15.0,
                    maxTemperature = 25.0,
                    weatherCode = 0
                )
            )
        )

        // 2. ACT
        val weatherInfo = fakeEntity.toWeatherInfo()

        // 3. ASSERT
        assertThat(weatherInfo.currentWeather).isNotNull()
        assertThat(weatherInfo.currentWeather?.temperature).isEqualTo(22.0)
        assertThat(weatherInfo.currentWeather?.humidity).isEqualTo(60.0)
        assertThat(weatherInfo.currentWeather?.weatherType).isEqualTo(WeatherType.ClearSky)
        assertThat(weatherInfo.hourlyForecast).hasSize(1)
        assertThat(weatherInfo.dailyForecast).hasSize(1)
        assertThat(weatherInfo.updatedAtTimestamp).isEqualTo(1711823400000L)
    }

    @Test
    fun `toWeatherEntity filters out hourly forecast items that are not from today`() {
        // 1. ARRANGE
        val todayIso = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        val tomorrowIso = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_DATE_TIME)

        val fakeDto = WeatherResponseDto(
            currentWeather = CurrentWeatherDto(
                25.0,
                50.0,
                1013.0,
                10.0,
                0
            ),
            hourlyWeather = HourlyWeatherDto(
                time = listOf(todayIso, tomorrowIso),
                temperature = listOf(25.0, 20.0),
                weatherCode = listOf(0, 0)
            ),
            dailyWeather = DailyWeatherDto(emptyList(), emptyList(), emptyList(), emptyList())
        )

        // 2. ACT
        val entity = fakeDto.toWeatherEntity("Madrid", "España")

        // 3. ASSERT
        assertThat(entity.hourlyForecast).hasSize(1)
        assertThat(entity.hourlyForecast.first().time).isEqualTo(todayIso)
    }
}