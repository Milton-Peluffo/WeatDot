package com.tomildev.weatdot.features.mainview.presentation.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Dimens
import com.tomildev.weatdot.ui.theme.NDotFontFamily
import com.tomildev.weatdot.ui.theme.TechMonoFontFamily

@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    data: String,
    dataUnits: String,
    dataDescription: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 13.dp),
        ) {
            Texts.BodySmall(text = dataDescription, isSecondary = true, fontFamily = TechMonoFontFamily)
            VerticalSpacer(Dimens.SpacingTiny)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Texts.TitleSmall(
                    text = data,
                    fontWeight = FontWeight.Normal,
                    fontFamily = NDotFontFamily
                )
                HorizontalSpacer(Dimens.SpacingTiny)
                Texts.Body(text = dataUnits, fontWeight = FontWeight.Normal, isSecondary = true, fontFamily = TechMonoFontFamily)
            }
        }
    }
}