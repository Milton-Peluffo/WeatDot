package com.tomildev.weatdot.features.mainview.presentation

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.tomildev.weatdot.R
import com.tomildev.weatdot.core.domain.model.CurrentWeather
import com.tomildev.weatdot.core.domain.model.UserLocation
import com.tomildev.weatdot.core.domain.model.WeatherInfo
import com.tomildev.weatdot.core.domain.model.WeatherType
import com.tomildev.weatdot.core.domain.use_case.AppUseCases
import com.tomildev.weatdot.core.domain.use_case.FetchWeatherUseCase
import com.tomildev.weatdot.core.domain.use_case.GetCityAndCountryUseCase
import com.tomildev.weatdot.core.domain.use_case.GetLocationUseCase
import com.tomildev.weatdot.core.domain.use_case.GetSavedLocationUseCase
import com.tomildev.weatdot.core.domain.use_case.GetWeatherFlowUseCase
import com.tomildev.weatdot.core.domain.use_case.SaveLocationUseCase
import com.tomildev.weatdot.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Unit test suite for [MainViewViewModel].
 *
 * Verifies:
 * - Reactive UI state updates when location preferences and Room cache emit.
 * - Loading and status message state flow during weather data refresh.
 */
class MainViewViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    // Use case mocks
    private val getWeatherFlowUseCase: GetWeatherFlowUseCase = mockk()
    private val fetchWeatherUseCase: FetchWeatherUseCase = mockk()
    private val getLocationUseCase: GetLocationUseCase = mockk()
    private val getCityAndCountryUseCase: GetCityAndCountryUseCase = mockk()
    private val getSavedLocationUseCase: GetSavedLocationUseCase = mockk()
    private val saveLocationUseCase: SaveLocationUseCase = mockk()

    private lateinit var appUseCases: AppUseCases
    private lateinit var viewModel: MainViewViewModel

    private val fakeUserLocation = UserLocation(
        latitude = 40.4168,
        longitude = -3.7038,
        cityName = "Madrid",
        countryName = "España"
    )

    private val fakeWeatherInfo = WeatherInfo(
        currentWeather = CurrentWeather(
            temperature = 22.0,
            humidity = 60.0,
            pressure = 1015.0,
            windSpeed = 8.5,
            weatherType = WeatherType.ClearSky
        ),
        updatedAtTimestamp = 1711823400000L
    )

    @Before
    fun setUp() {
        appUseCases = AppUseCases(
            getWeatherFlowUseCase = getWeatherFlowUseCase,
            fetchWeatherUseCase = fetchWeatherUseCase,
            getLocationUseCase = getLocationUseCase,
            getCityAndCountryUseCase = getCityAndCountryUseCase,
            getSavedLocationUseCase = getSavedLocationUseCase,
            saveLocationUseCase = saveLocationUseCase
        )

        // default return values for use cases
        every { getSavedLocationUseCase() } returns flowOf(fakeUserLocation)
        every { getWeatherFlowUseCase() } returns flowOf(fakeWeatherInfo)
        coEvery { getLocationUseCase() } returns null
        coEvery { getCityAndCountryUseCase(any(), any(), any()) } returns fakeUserLocation
        coEvery { saveLocationUseCase(any()) } returns Unit
        coEvery { fetchWeatherUseCase(any(), any(), any(), any()) } returns Result.success(Unit)
    }

    @Test
    fun `init collects saved location and Room cache updating uiState correctly`() = runTest {
        viewModel = MainViewViewModel(appUseCases = appUseCases)

        viewModel.uiState.test {
            val state = awaitItem()
            assertThat(state.cityName).isEqualTo("Madrid")
            assertThat(state.countryName).isEqualTo("España")
            assertThat(state.weatherInfo).isEqualTo(fakeWeatherInfo)
        }
    }

    @Test
    fun `refreshWeatherData emits updating status and then success status`() = runTest {
        every { getSavedLocationUseCase() } returns emptyFlow()

        viewModel = MainViewViewModel(appUseCases = appUseCases)

        viewModel.uiState.test {
            val initialState = awaitItem()
            assertThat(initialState.statusMessageRes).isNull()

            viewModel.refreshWeatherData(
                lat = 40.4168,
                long = -3.7038,
                cityName = "Madrid",
                countryName = "España"
            )

            val updatingState = awaitItem()
            assertThat(updatingState.statusMessageRes).isEqualTo(R.string.main_view_message_updating)

            val updatedState = awaitItem()
            assertThat(updatedState.statusMessageRes).isEqualTo(R.string.main_view_message_updated)

            cancelAndIgnoreRemainingEvents()
        }
    }
}