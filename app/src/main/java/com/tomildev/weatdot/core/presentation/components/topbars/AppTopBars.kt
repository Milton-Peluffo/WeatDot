package com.tomildev.weatdot.core.presentation.components.topbars

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tomildev.weatdot.core.presentation.components.buttons.AppButtons
import com.tomildev.weatdot.ui.theme.Dimens

object AppTopBars {
    @Composable
    fun ButtonTopBar(
        modifier: Modifier = Modifier,
        @DrawableRes icon: Int,
        onClick: () -> Unit,
        @DrawableRes trailingIcon: Int? = null,
        onTrailingIconClick: (() -> Unit)? = null,
        trailingContent: (@Composable () -> Unit)? = null
    ) {
        val leadingInteractionSource = remember { MutableInteractionSource() }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = Dimens.ScreenHorizontalPadding)
                .height(Dimens.ComponentHeightLarge)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(Dimens.ComponentHeightLarge)
                    .clickable(
                        interactionSource = leadingInteractionSource,
                        indication = null,
                        onClick = onClick
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                AppButtons.IconButton(
                    icon = icon,
                    onClick = onClick
                )
            }

            if (trailingContent != null) {
                Box(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    trailingContent()
                }
            } else if (trailingIcon != null) {
                val trailingInteractionSource = remember { MutableInteractionSource() }
                val onTrailingClick = onTrailingIconClick ?: {}

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(Dimens.ComponentHeightLarge)
                        .clickable(
                            interactionSource = trailingInteractionSource,
                            indication = null,
                            onClick = onTrailingClick
                        ),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    AppButtons.IconButton(
                        modifier = Modifier,
                        icon = trailingIcon,
                        onClick = onTrailingClick
                    )
                }
            }
        }
    }
}