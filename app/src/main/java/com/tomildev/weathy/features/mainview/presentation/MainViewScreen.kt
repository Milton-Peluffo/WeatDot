package com.tomildev.weathy.features.mainview.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.tomildev.weathy.R
import com.tomildev.weathy.core.presentation.components.cards.InformationCard
import com.tomildev.weathy.core.presentation.components.scaffolds.AppScaffold
import com.tomildev.weathy.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weathy.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weathy.core.presentation.components.texts.Texts
import com.tomildev.weathy.core.presentation.components.topbars.AppTopBars
import com.tomildev.weathy.features.mainview.presentation.components.WeatherDataContainer
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.NDotFontFamily
import com.tomildev.weathy.ui.theme.WeathyDrawables

@Composable
fun MainViewScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val currentWeather = uiState.weatherInfo?.currentWeather
    val weatherType = currentWeather?.weatherType

    AppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppTopBars.ButtonTopBar(icon = WeathyDrawables.Icons.Menu, onClick = {})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = Dimens.ScreenHorizontalPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Texts.TitleMedium(text = uiState.cityName)
                Texts.Body(text = uiState.countryName, isSecondary = true)
                VerticalSpacer(Dimens.SpacingLarge)
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Texts.Headline(
                        text = "${currentWeather?.temperature?.toInt()}",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Normal,
                        fontFamily = NDotFontFamily
                    )
                    HorizontalSpacer(Dimens.SpacingSmall)
                    Texts.Headline(
                        text = "°C",
                        color = Color(0xFFff2a2a),
                        fontWeight = FontWeight.Normal,
                        fontFamily = NDotFontFamily
                    )
                }
//                VerticalSpacer(Dimens.SpacingSmall)
//                Texts.Body(
//                    text = stringResource(R.string.main_view_today),
//                    color = Color.White,
//                    isSecondary = true
//                )
            }
            VerticalSpacer(Dimens.SpacingSmall)
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.zIndex(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    val backgroundRes =
//                        WeathyDrawables.Backgrounds.Thunderstorm

                    val backgroundRes =
                        weatherType?.backgroundRes ?: WeathyDrawables.Backgrounds.Thunderstorm
                    val lottieComposition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(backgroundRes)
                    )

                    LottieAnimation(
                        composition = lottieComposition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.2f)
                    )
                    VerticalSpacer(Dimens.SpacingSmall)
                    Card(
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainer
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(end = Dimens.SpacingTiny)
                                    .size(Dimens.IconSizeNormal),
                                painter = painterResource(
                                    weatherType?.iconRes ?: WeathyDrawables.Icons.ClearSky
                                ),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                            Texts.Body(
                                text = weatherType?.let { stringResource(it.weatherDescRes) }
                                    ?: "Empty",
                            )
                        }
                    }
                }
            }
            VerticalSpacer(Dimens.SpacingSmall)
            WeatherDataContainer {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    InformationCard(
                        icon = WeathyDrawables.Icons.WaterDroplet,
                        data = "${currentWeather?.humidity?.toInt()}",
                        dataUnits = "%",
                        dataDescription = stringResource(R.string.main_view_humidity)
                    )
                    InformationCard(
                        icon = WeathyDrawables.Icons.Wind,
                        data = "${currentWeather?.windSpeed?.toString()}",
                        dataUnits = "km/h",
                        dataDescription = stringResource(R.string.main_view_wind_speed)
                    )
                    InformationCard(
                        icon = WeathyDrawables.Icons.Pressure,
                        data = "${currentWeather?.pressure?.toInt()}",
                        dataUnits = "hPa",
                        dataDescription = stringResource(R.string.main_view_pressure)
                    )
                }
            }
        }
    }
}