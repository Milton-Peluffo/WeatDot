package com.tomildev.weatdot.core.presentation.components.selection

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tomildev.weatdot.core.presentation.components.containers.AppBox
import com.tomildev.weatdot.core.presentation.components.containers.AppBoxDefaults
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Alpha
import com.tomildev.weatdot.ui.theme.Dimens

@Immutable
class AppChipColors(
    private val containerColor: Color,
    private val selectedContainerColor: Color,
    private val contentColor: Color,
    private val selectedContentColor: Color,
    private val borderColor: Color,
    private val selectedBorderColor: Color,
) {
    @Composable
    fun containerColor(isSelected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (isSelected) selectedContainerColor else containerColor,
            label = "chip_container_color",
        )
    }

    @Composable
    fun contentColor(isSelected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (isSelected) selectedContentColor else contentColor,
            label = "chip_content_color"
        )
    }

    @Composable
    fun borderColor(isSelected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (isSelected) selectedBorderColor else borderColor,
            label = "chip_border_color"
        )
    }
}

object AppChipDefaults {
    @Composable
    fun chipColors(
        selectedColor: Color = MaterialTheme.colorScheme.secondary,
        containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        selectedContainerColor: Color = selectedColor.copy(alpha = Alpha.AlphaLow),
        contentColor: Color = MaterialTheme.colorScheme.onSurface.copy(Alpha.AlphaHigh),
        selectedContentColor: Color = lerp(
            MaterialTheme.colorScheme.onSurface,
            selectedColor,
            0.2f
        ),
        borderColor: Color = Color.Transparent,
        selectedBorderColor: Color = selectedColor,
    ): AppChipColors = AppChipColors(
        containerColor = containerColor,
        selectedContainerColor = selectedContainerColor,
        contentColor = contentColor,
        selectedContentColor = selectedContentColor,
        borderColor = borderColor,
        selectedBorderColor = selectedBorderColor
    )
}

/**
 * AppChip with label composable as param for apply any type of text type and style
 */
@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    iconRes: Int? = null,
    iconSize: Dp = Dimens.IconSizeNormal,
    isSelected: Boolean = false,
    hasBorder: Boolean = true,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    isClickable: Boolean = true,
    height: Dp = Dimens.ComponentHeightNormal,
    shape: Shape = MaterialTheme.shapes.large,
    colors: AppChipColors = AppChipDefaults.chipColors(),
    label: @Composable (contentColor: Color) -> Unit,
) {
    val containerColor = colors.containerColor(isSelected)
    val contentColor = colors.contentColor(isSelected)
    val borderColor = colors.borderColor(isSelected)

    AppBox(
        modifier = modifier.height(height),
        onClick = onClick,
        shape = shape,
        onLongClick = onLongClick,
        hasBorder = hasBorder,
        colors = AppBoxDefaults.boxColors(
            containerColor = containerColor.value,
            borderColor = borderColor.value
        ),
        isClickable = isClickable,
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = Dimens.SpacingSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize),
                    tint = contentColor.value
                )
                HorizontalSpacer(Dimens.SpacingTiny)
            }
            label(contentColor.value)
        }
    }
}

/**
 * AppChip version for default text styles.
 */
@Composable
fun AppChip(
    text: String,
    modifier: Modifier = Modifier,
    iconRes: Int? = null,
    iconSize: Dp = Dimens.IconSizeNormal,
    isSelected: Boolean = false,
    hasBorder: Boolean = true,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    isClickable: Boolean = true,
    height: Dp = Dimens.ComponentHeightNormal,
    shape: Shape = MaterialTheme.shapes.large,
    colors: AppChipColors = AppChipDefaults.chipColors(),
) {
    AppChip(
        modifier = modifier,
        iconRes = iconRes,
        iconSize = iconSize,
        isSelected = isSelected,
        hasBorder = hasBorder,
        onClick = onClick,
        onLongClick = onLongClick,
        isClickable = isClickable,
        height = height,
        shape = shape,
        colors = colors,
        label = { contentColor ->
            Texts.LabelMedium(
                text = text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = contentColor
            )
        }
    )
}