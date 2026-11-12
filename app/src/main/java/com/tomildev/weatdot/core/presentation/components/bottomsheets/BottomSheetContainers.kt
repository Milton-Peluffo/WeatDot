package com.tomildev.weatdot.core.presentation.components.bottomsheets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.tomildev.weatdot.core.presentation.components.buttons.AppButtons
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.AppDrawables
import com.tomildev.weatdot.ui.theme.Dimens

object BottomSheetContainers {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Close(
        modifier: Modifier = Modifier,
        title: String? = null,
        subtitle: String? = null,
        onDismissRequest: () -> Unit,
        sheetState: SheetState,
        scrollState: ScrollState? = null,
        contentModifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Base(
            modifier = modifier,
            title = title,
            subtitle = subtitle,
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            scrollState = scrollState,
            contentModifier = contentModifier,
            header = {
                HeaderWrapper {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        AppButtons.IconButton(
                            onClick = onDismissRequest,
                            icon = AppDrawables.Icons.Close
                        )
                    }
                }
            },
            content = content
        )
    }

    @Composable
    private fun HeaderWrapper(
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            content()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Base(
        modifier: Modifier = Modifier,
        title: String? = null,
        subtitle: String? = null,
        onDismissRequest: () -> Unit,
        sheetState: SheetState,
        scrollState: ScrollState? = null,
        contentModifier: Modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.ScreenHorizontalPadding),
        dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
        header: @Composable (() -> Unit)? = null,
        content: @Composable () -> Unit
    ) {
        val backgroundColor = MaterialTheme.colorScheme.surfaceContainerHigh

        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPostScroll(
                    consumed: Offset,
                    available: Offset,
                    source: NestedScrollSource
                ): Offset = available
            }
        }

        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            dragHandle = dragHandle,
            containerColor = backgroundColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.ScreenHorizontalPadding)
            ) {
                header?.let {
                    it()
                    Spacer(modifier = Modifier.height(Dimens.SpacingSmall))
                }

                if (!title.isNullOrBlank() || !subtitle.isNullOrBlank()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        if (!title.isNullOrBlank()) {
                            Texts.TitleMedium(text = title)
                        }
                        if (!title.isNullOrBlank() && !subtitle.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(Dimens.SpacingTiny))
                        }
                        if (!subtitle.isNullOrBlank()) {
                            Texts.LabelLarge(text = subtitle)
                        }
                        Spacer(modifier = Modifier.height(Dimens.SpacingLarge))
                    }
                }

                Column(
                    modifier = contentModifier
                        .fillMaxWidth()
                        .nestedScroll(nestedScrollConnection)
                        .let { if (scrollState != null) it.verticalScroll(scrollState) else it }
                ) {
                    content()
                }
            }
        }
    }
}