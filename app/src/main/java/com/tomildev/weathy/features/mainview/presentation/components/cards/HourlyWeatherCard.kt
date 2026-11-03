package com.tomildev.weathy.features.mainview.presentation.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tomildev.weathy.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weathy.core.presentation.components.texts.Texts
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.NDotFontFamily

@Composable
fun HourlyWeatherCard(
    modifier: Modifier = Modifier,
    hour: String,
    period: String? = null,
    temperature: String,
    icon: Int,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        shape = MaterialTheme.shapes.extraLarge,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 13.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Texts.BodySmall(text = hour, isSecondary = true)
            if (period != null) {
                VerticalSpacer(Dimens.SpacingTiny)
                Texts.BodySmall(text = period, isSecondary = true)
            }
            VerticalSpacer(Dimens.SpacingExtraSmall)
            Icon(
                painter = painterResource(icon),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface
            )
            VerticalSpacer(Dimens.SpacingExtraSmall)
            Texts.TitleSmall(
                text = temperature,
                fontWeight = FontWeight.Normal,
                fontFamily = NDotFontFamily
            )
            VerticalSpacer(Dimens.SpacingExtraSmall)
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xFFff2a2a))
            )
        }
    }
}