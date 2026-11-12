package com.tomildev.weatdot.features.mainview.preferences.app_preferences

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tomildev.weatdot.R
import com.tomildev.weatdot.core.presentation.components.fields.LabeledField
import com.tomildev.weatdot.core.presentation.components.listitems.AppListItem
import com.tomildev.weatdot.core.presentation.components.listitems.AppListItemOption
import com.tomildev.weatdot.ui.theme.AppDrawables

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPreferencesBottomSheet(
    modifier: Modifier = Modifier, onDismissRequest: () -> Unit
) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    LabeledField(
        label = stringResource(R.string.main_view_pressure),
        isSecondary = true
    ) {
        AppListItem.Selection(
            icon = AppDrawables.Icons.ClearSky,
            title = stringResource(R.string.main_view_pressure),
            subtitle = stringResource(R.string.main_view_pressure),
            options = listOf(
                AppListItemOption(
                    text = stringResource(R.string.main_view_pressure),
                    iconRes = AppDrawables.Icons.ClearSky,
                    isSelected = true,
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    onClick = { }
                ),
                AppListItemOption(
                    text = stringResource(R.string.main_view_pressure),
                    iconRes = AppDrawables.Icons.ClearSky,
                    isSelected = false,
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    onClick = { }
                )
            )
        )
    }
}