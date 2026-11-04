package com.tomildev.weathy.core.presentation.components.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.tomildev.weathy.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.TechMonoFontFamily

@Composable
fun SectionText(modifier: Modifier = Modifier, text: String) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = Dimens.SpacingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondary)
        )
        HorizontalSpacer(Dimens.SpacingSmall)
        Texts.BodySmall(
            text = text,
            fontFamily = TechMonoFontFamily
        )
    }
}