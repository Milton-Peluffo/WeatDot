package com.tomildev.weatdot.features.mainview.presentation.components.cards

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Dimens
import com.tomildev.weatdot.ui.theme.NDotFontFamily
import com.tomildev.weatdot.ui.theme.TechMonoFontFamily

@Composable
fun DailyWeatherItemCard(
    modifier: Modifier = Modifier,
    dayName: String,
    icon: Int,
    minTemperature: String,
    maxTemperature: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.SpacingSmall, horizontal = Dimens.SpacingMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texts.BodySmall(
                text = dayName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                fontFamily = TechMonoFontFamily
            )

            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(Dimens.IconSizeNormal),
                tint = MaterialTheme.colorScheme.onSurface
            )

            HorizontalSpacer(Dimens.SpacingLarge)

            Texts.Body(
                text = minTemperature,
                fontFamily = NDotFontFamily,
                isSecondary = true
            )

            HorizontalSpacer(Dimens.SpacingSmall)

            Texts.Body(
                text = maxTemperature,
                fontFamily = NDotFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}