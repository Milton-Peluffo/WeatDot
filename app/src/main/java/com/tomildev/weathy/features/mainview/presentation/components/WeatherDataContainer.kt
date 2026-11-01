package com.tomildev.weathy.features.mainview.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tomildev.weathy.ui.theme.Dimens

@Composable
fun WeatherDataContainer(
    modifier: Modifier = Modifier,
    dragHandleColor: Color = Color(0xFFff2a2a),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                )
            )
            .background(Color(0xFF1c1c1e))
    ) {
        Box(
            modifier = Modifier
                .padding(top = Dimens.SpacingSmall)
                .width(36.dp)
                .height(4.dp)
                .clip(CircleShape)
                .background(dragHandleColor)
                .align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.SpacingExtraLarge),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}