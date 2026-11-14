package com.tomildev.weatdot.core.presentation.components.selection

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tomildev.weatdot.ui.theme.Alpha

@Composable
fun AppSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkedThumbColor: Color = MaterialTheme.colorScheme.primary,
    checkedTrackColor: Color = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.AlphaLow),
    checkedBorderColor: Color = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.AlphaHigh)
) {

    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = checkedThumbColor,
            checkedTrackColor = checkedTrackColor,
            checkedBorderColor = checkedBorderColor,
            uncheckedThumbColor = MaterialTheme.colorScheme.primary,
            uncheckedTrackColor = MaterialTheme.colorScheme.onPrimary,
            uncheckedIconColor = MaterialTheme.colorScheme.outline,
        )
    )
}