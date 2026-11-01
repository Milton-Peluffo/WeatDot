package com.tomildev.weathy.core.presentation.components.topbars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tomildev.weathy.core.presentation.components.buttons.AppButtons
import com.tomildev.weathy.ui.theme.Dimens

object AppTopBars {
    @Composable
    fun ButtonTopBar(
        modifier: Modifier = Modifier,
        icon: Int,
        onClick: () -> Unit
    ) {
        val interactionSource = remember { MutableInteractionSource() }

        Box(
            modifier = modifier
                .statusBarsPadding()
                .padding(horizontal = Dimens.ScreenHorizontalPadding)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, onClick = onClick
                )
                .size(height = 56.dp, width = 55.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            AppButtons.IconButton(
                icon = icon,
                onClick = onClick
            )
        }
    }
}