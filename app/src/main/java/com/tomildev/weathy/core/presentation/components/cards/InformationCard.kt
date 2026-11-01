package com.tomildev.weathy.core.presentation.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tomildev.weathy.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weathy.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weathy.core.presentation.components.texts.Texts
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.NDotFontFamily

@Composable
fun InformationCard(
    icon: Int,
    iconColor: Color = MaterialTheme.colorScheme.onSurface,
    data: String,
    dataUnits: String,
    dataDescription: String
) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 13.dp),

            ) {
            Texts.BodySmall(text = dataDescription, isSecondary = true)
            VerticalSpacer(Dimens.SpacingTiny)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Texts.TitleSmall(text = data, fontWeight = FontWeight.Normal, fontFamily = NDotFontFamily)
                HorizontalSpacer(Dimens.SpacingTiny)
                Texts.Body(text = dataUnits, fontWeight = FontWeight.Normal, isSecondary = true)
            }
        }
    }
}