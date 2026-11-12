package com.tomildev.weatdot.features.mainview.presentation

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tomildev.weatdot.R
import com.tomildev.weatdot.core.presentation.components.scaffolds.AppScaffold
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.SectionText
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.core.presentation.components.topbars.AppTopBars
import com.tomildev.weatdot.core.util.TimeFormatter
import com.tomildev.weatdot.features.mainview.preferences.app_preferences.AppPreferencesBottomSheet
import com.tomildev.weatdot.features.mainview.presentation.components.WeatherDataContainer
import com.tomildev.weatdot.features.mainview.presentation.components.cards.DailyWeatherItemCard
import com.tomildev.weatdot.features.mainview.presentation.components.cards.HourlyWeatherCard
import com.tomildev.weatdot.features.mainview.presentation.components.cards.InformationCard
import com.tomildev.weatdot.ui.theme.AppDrawables
import com.tomildev.weatdot.ui.theme.Dimens
import com.tomildev.weatdot.ui.theme.NDotFontFamily
import com.tomildev.weatdot.ui.theme.TechMonoFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainViewScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permission ->
        val isGranted = permission.values.all { it }
        if (isGranted) {
            viewModel.fetchCurrentGpsLocation()
        }

    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    MainViewContent(
        modifier = modifier,
        uiState = uiState,
        onRefresh = { }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainViewContent(
    modifier: Modifier = Modifier,
    uiState: MainViewUiState,
    onRefresh: () -> Unit
) {
    val currentWeather = uiState.weatherInfo?.currentWeather
    val context = LocalContext.current
    val systemFormat = TimeFormatter.getSystemTimeFormat(context)
    val scrollState = rememberScrollState()
    val screenState = rememberMainViewScreenState()


    AppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppTopBars.ButtonTopBar(
                icon = AppDrawables.Icons.Menu,
                onClick = { screenState.openMainViewPreferences() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            MainViewHeader(
                uiState = uiState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.ScreenHorizontalPadding)
                    .graphicsLayer {
                        val scroll = scrollState.value
                        translationY = scroll * 0.65f
                        val fadeDistance = size.height * 0.7f
                        alpha = if (fadeDistance > 0f) {
                            (1f - (scroll / fadeDistance)).coerceIn(0f, 1f)
                        } else 1f
                    }
            )

            WeatherDataContainer(
                modifier = Modifier.padding(horizontal = Dimens.ScreenHorizontalPadding)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InformationCard(
                        data = "${currentWeather?.humidity?.toInt() ?: "--"}",
                        dataUnits = "%",
                        dataDescription = stringResource(R.string.main_view_humidity)
                    )
                    InformationCard(
                        data = "${currentWeather?.windSpeed ?: "--"}",
                        dataUnits = "km/h",
                        dataDescription = stringResource(R.string.main_view_wind_speed)
                    )
                    InformationCard(
                        data = "${currentWeather?.pressure?.toInt() ?: "--"}",
                        dataUnits = "hPa",
                        dataDescription = stringResource(R.string.main_view_pressure)
                    )
                }

                SectionText(text = stringResource(R.string.main_view_today_forecast))

                val hourlyForecast = uiState.weatherInfo?.hourlyForecast ?: emptyList()

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.SpacingTiny),
                ) {
                    items(
                        items = hourlyForecast,
                        key = { it.time }
                    ) { hourlyItem ->
                        val formattedTime = TimeFormatter.formatHour(hourlyItem.time, systemFormat)
                        HourlyWeatherCard(
                            hour = formattedTime.hour,
                            period = formattedTime.period,
                            temperature = "${hourlyItem.temperature.toInt()}°",
                            icon = hourlyItem.weatherType.iconRes
                        )
                    }
                }

                SectionText(text = stringResource(R.string.main_view_seven_days_forecast))

                val dailyForecast = uiState.weatherInfo?.dailyForecast ?: emptyList()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.SpacingTiny),
                ) {
                    dailyForecast.forEach { dailyItem ->
                        val dayNameText = if (dailyItem.isToday) {
                            stringResource(R.string.main_view_today_day, dailyItem.dayName)
                        } else {
                            dailyItem.dayName
                        }

                        DailyWeatherItemCard(
                            dayName = dayNameText,
                            icon = dailyItem.weatherType.iconRes,
                            minTemperature = "${dailyItem.minTemperature.toInt()}°",
                            maxTemperature = "${dailyItem.maxTemperature.toInt()}°"
                        )
                    }
                }
            }
        }
        when (val action = screenState.activeAction) {
            is MainScreenAction.MainViewPreferences -> {
                AppPreferencesBottomSheet(onDismissRequest = {})
            }

            else -> {}
        }
    }
}

@Composable
private fun MainViewHeader(
    uiState: MainViewUiState,
    modifier: Modifier = Modifier
) {
    val currentWeather = uiState.weatherInfo?.currentWeather
    val weatherType = currentWeather?.weatherType

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texts.TitleLarge(
            text = uiState.cityName, fontFamily = TechMonoFontFamily,
        )
        Texts.TitleSmall(
            text = uiState.countryName,
            isSecondary = true,
            fontFamily = TechMonoFontFamily
        )
        VerticalSpacer(Dimens.SpacingLarge)

        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texts.Headline(
                text = "${currentWeather?.temperature?.toInt() ?: "--"}",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Normal,
                fontFamily = NDotFontFamily
            )
            HorizontalSpacer(Dimens.SpacingSmall)
            Texts.Headline(
                text = "°C",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Normal,
                fontFamily = NDotFontFamily
            )
        }

        VerticalSpacer(Dimens.SpacingSmall)

        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.zIndex(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val backgroundRes =
                    weatherType?.backgroundRes ?: AppDrawables.Backgrounds.Thunderstorm
                val lottieComposition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(backgroundRes)
                )

                LottieAnimation(
                    composition = lottieComposition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.3f)
                )

                VerticalSpacer(Dimens.SpacingTiny)

                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = Dimens.SpacingTiny)
                            .size(Dimens.IconSizeNormal),
                        painter = painterResource(
                            weatherType?.iconRes ?: AppDrawables.Icons.ClearSky
                        ),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Texts.Body(
                        text = weatherType?.let { stringResource(it.weatherDescRes) }
                            ?: "Empty",
                        fontFamily = TechMonoFontFamily
                    )
                }
            }
        }

        VerticalSpacer(Dimens.SpacingSmall)
    }
}