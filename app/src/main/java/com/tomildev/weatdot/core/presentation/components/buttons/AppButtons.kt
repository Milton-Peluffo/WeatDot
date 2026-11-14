package com.tomildev.weatdot.core.presentation.components.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

object AppButtons {

    @Composable
    fun IconButton(
        modifier: Modifier = Modifier,
        icon: Int,
        onClick: () -> Unit
    ) {
        IconButton(
            modifier = modifier,
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