package com.tomildev.weatdot.core.presentation.components.containers

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Alpha
import com.tomildev.weatdot.ui.theme.Dimens

@Immutable
class AppBoxColors(
    val containerColor: Color,
    val disabledContainerColor: Color,
    val borderColor: Color,
    val disabledBorderColor: Color,
    val rippleColor: Color
) {
    @Composable
    fun containerColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (enabled) containerColor else disabledContainerColor,
            label = "box_container_color"
        )
    }

    @Composable
    fun borderColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (enabled) borderColor else disabledBorderColor,
            label = "box_border_color"
        )
    }
}

object AppBoxDefaults {
    @Composable
    fun boxColors(
        containerColor: Color = MaterialTheme.colorScheme.surfaceContainer,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surfaceContainer.copy(alpha = Alpha.AlphaLow),
        borderColor: Color = MaterialTheme.colorScheme.outline.copy(alpha = Alpha.AlphaLow),
        disabledBorderColor: Color = MaterialTheme.colorScheme.outline.copy(alpha = Alpha.AlphaLow),
        rippleColor: Color = MaterialTheme.colorScheme.onSurface,
    ): AppBoxColors = AppBoxColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        borderColor = borderColor,
        disabledBorderColor = disabledBorderColor,
        rippleColor = rippleColor
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppBox(
    modifier: Modifier = Modifier,
    title: String? = null,
    caption: String? = null,
    onClick: () -> Unit = {},
    onLongClick: (() -> Unit)? = null,
    hasBorder: Boolean = false,
    isClickable: Boolean = true,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    colors: AppBoxColors = AppBoxDefaults.boxColors(),
    contentAlignment: Alignment = Alignment.Center,
    alpha: Float = 1f,
    elevation: Dp = 0.dp,
    content: @Composable BoxScope.() -> Unit
) {
    val containerColor = colors.containerColor(enabled).value
    val borderColor = colors.borderColor(enabled).value

    Box(
        modifier = modifier
            .shadow(
                elevation = elevation,
                shape = shape
            )
            .clip(shape = shape)
            .let { modifier ->
                if (hasBorder)
                    modifier.border(
                        width = Dimens.BorderSmall,
                        color = borderColor,
                        shape = shape
                    )
                else modifier
            }
            .let { modifier ->
                if (isClickable)
                    modifier.combinedClickable(
                        onClick = onClick,
                        onLongClick = onLongClick,
                        enabled = enabled,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(color = colors.rippleColor)
                    )
                else modifier
            }
            .background(containerColor.copy(alpha = containerColor.alpha * alpha)),
        contentAlignment = contentAlignment
    ) {
        Box(
            modifier = Modifier,
            contentAlignment = if (!title.isNullOrBlank() || !caption.isNullOrBlank()) Alignment.TopStart else contentAlignment
        ) {
            if (!title.isNullOrBlank() || !caption.isNullOrBlank()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.SpacingMedium),
                    verticalArrangement = Arrangement.spacedBy(Dimens.SpacingSmall)
                ) {
                    if (!title.isNullOrBlank()) {
                        Texts.TitleSmall(
                            text = title,
                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = contentAlignment
                    ) {
                        content()
                    }

                    if (!caption.isNullOrBlank()) {
                        Texts.LabelMedium(
                            modifier = Modifier.fillMaxWidth(),
                            text = caption,
                            textAlign = TextAlign.Center,
                            isSecondary = true
                        )
                    }
                }
            } else {
                content()
            }
        }
    }
}