package com.tomildev.weatdot.features.mainview.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

sealed interface MainScreenAction {
    object MainViewPreferences : MainScreenAction

    object ChangeLanguage : MainScreenAction
    object WeatherSyncStatus : MainScreenAction
}

@OptIn(ExperimentalMaterial3Api::class)
class MainViewScreenState(
    activeActionState: MutableState<MainScreenAction?>,
    val sheetState: SheetState,
) {
    var activeAction by activeActionState

    // ============== INTERACTION FUNCTIONS ==============

    fun showLastWeatherUpdatedDialog() {
        activeAction = MainScreenAction.WeatherSyncStatus
    }

    fun openMainViewPreferences() {
        activeAction = MainScreenAction.MainViewPreferences
    }

    fun openChangeLanguage() {
        activeAction = MainScreenAction.ChangeLanguage
    }

    fun dismissAction() {
        activeAction = null
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberMainViewScreenState(
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
): MainViewScreenState {
    val activeActionState = rememberSaveable { mutableStateOf<MainScreenAction?>(null) }

    return remember(sheetState) {
        MainViewScreenState(
            sheetState = sheetState,
            activeActionState = activeActionState,
        )
    }
}