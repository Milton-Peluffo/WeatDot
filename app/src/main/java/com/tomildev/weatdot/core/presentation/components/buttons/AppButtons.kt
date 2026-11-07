package com.tomildev.weatdot.core.presentation.components.buttons

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

object AppButtons {

    @Composable
    fun IconButton(
        modifier: Modifier = Modifier,
        icon: Int,
        onClick: () -> Unit
    ) {
        IconButton(
            modifier = modifier.offset(x = (-10).dp),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(
                    icon
                ),
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = null,
            )
        }
    }
}