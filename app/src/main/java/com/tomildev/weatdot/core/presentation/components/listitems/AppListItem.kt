package com.tomildev.weatdot.core.presentation.components.listitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tomildev.weatdot.core.presentation.components.containers.AppBox
import com.tomildev.weatdot.core.presentation.components.containers.AppBoxDefaults
import com.tomildev.weatdot.core.presentation.components.selection.AppChip
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Alpha
import com.tomildev.weatdot.ui.theme.Dimens
import com.tomildev.weatdot.ui.theme.AppDrawables

data class AppListItemOption(
    val text: String,
    val iconRes: Int,
    val isSelected: Boolean,
    val selectedColor: Color,
    val onClick: () -> Unit
)

private val LocalIsGrouped = compositionLocalOf { false }

object AppListItem {

    @Composable
    fun Static(
        modifier: Modifier = Modifier,
        icon: Int? = null,
        containerColor: Color? = null,
        title: String,
        subtitle: String? = null,
        isWarning: Boolean = false,
        trailingContent: @Composable (() -> Unit)? = null,
    ) {
        val contentColor =
            if (isWarning) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface

        AppListItemContainer(
            modifier = modifier,
            containerColor = containerColor
        ) {
            ListItem(
                icon = icon,
                title = title,
                subtitle = subtitle,
                contentColor = contentColor,
                trailingContent = {
                    trailingContent?.invoke()
                })
        }
    }

    /** Componente de tipo navegación con icono chevron al final,
     * este puede contener un componente opcional para a la izquierda del icono para mostrar información específica.
     * */
    @Composable
    fun Navigation(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        icon: Int? = null,
        containerColor: Color? = null,
        title: String,
        subtitle: String? = null,
        trailingContent: @Composable (() -> Unit)? = null,
    ) {
        AppListItemContainer(
            modifier = modifier,
            containerColor = containerColor,
            onClick = onClick
        ) {
            ListItem(
                icon = icon,
                title = title,
                subtitle = subtitle,
                trailingContent = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        trailingContent?.invoke()
                    }
                    HorizontalSpacer(Dimens.SpacingExtraSmall)
                    Icon(
                        painter = painterResource(AppDrawables.Icons.ChevronRight),
                        contentDescription = null,
                        modifier = Modifier.size(Dimens.IconSizeNormal),
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = Alpha.AlphaMedium)
                    )
                }
            )
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun Selection(
        icon: Int? = null,
        containerColor: Color? = null,
        title: String,
        subtitle: String? = null,
        options: List<AppListItemOption>,
        modifier: Modifier = Modifier,
        columns: Int = 2
    ) {
        AppListItemContainer(modifier = modifier, containerColor = containerColor) {
            Column(modifier = Modifier.padding(Dimens.SpacingMedium)) {
                ListItem(
                    icon = icon,
                    title = title,
                    subtitle = subtitle,
                    padding = 0.dp
                )
                VerticalSpacer(Dimens.SpacingMedium)

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.SpacingSmall),
                    verticalArrangement = Arrangement.spacedBy(Dimens.SpacingSmall),
                    maxItemsInEachRow = columns
                ) {
                    options.forEach { option ->
                        AppChip(
                            modifier = Modifier.weight(1f),
                            text = option.text,
                            iconSize = Dimens.IconSizeExtraSmall,
                            iconRes = option.iconRes,
                            isSelected = option.isSelected,
                            onClick = option.onClick
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun AppListItemContainer(
        modifier: Modifier = Modifier,
        containerColor: Color? = null,
        onClick: (() -> Unit)? = null,
        content: @Composable BoxScope.() -> Unit
    ) {
        val isGrouped = LocalIsGrouped.current
        val defaultColor = MaterialTheme.colorScheme.surfaceContainerHighest
        val resolvedColor = containerColor ?: defaultColor

        AppBox(
            modifier = modifier.fillMaxWidth(),
            onClick = onClick ?: {},
            isClickable = onClick != null,
            colors = AppBoxDefaults.boxColors(
                containerColor = if (isGrouped) Color.Transparent else resolvedColor
            ),
            shape = if (isGrouped) RectangleShape else MaterialTheme.shapes.large,
            hasBorder = false,
            elevation = 0.dp,
            content = content
        )
    }

    @Composable
    private fun ListItem(
        icon: Int? = null,
        title: String,
        subtitle: String? = null,
        modifier: Modifier = Modifier,
        trailingContent: @Composable (() -> Unit)? = null,
        padding: Dp = Dimens.SpacingMedium,
        contentColor: Color = MaterialTheme.colorScheme.onSurface
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.IconSizeNormal),
                    tint = contentColor
                )

                HorizontalSpacer(Dimens.SpacingMedium)
            }

            Column(modifier = Modifier.weight(1f)) {
                Texts.Body(text = title, color = contentColor)

                if (!subtitle.isNullOrBlank()) {
                    Texts.LabelMedium(
                        text = subtitle,
                        isSecondary = true,
                        color = contentColor.copy(alpha = Alpha.AlphaHigh)
                    )
                }
            }
            HorizontalSpacer(Dimens.SpacingSmall)
            trailingContent?.invoke()
        }
    }
}
