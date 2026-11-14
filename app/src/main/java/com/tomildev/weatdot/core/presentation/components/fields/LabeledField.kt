package com.tomildev.weatdot.core.presentation.components.fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tomildev.weatdot.core.presentation.components.spacers.HorizontalSpacer
import com.tomildev.weatdot.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Dimens

@Composable
fun LabeledField(
    modifier: Modifier = Modifier,
    label: String? = null,
    labelExtension: String? = null,
    isSecondary: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {

        if (label != null) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Texts.LabelLarge(
                    text = label,
                    isSecondary = isSecondary
                )

                if (labelExtension != null) {
                    HorizontalSpacer(Dimens.SpacingTiny)

                    Texts.LabelLarge(
                        text = labelExtension,
                        isSecondary = true
                    )
                }
            }

            VerticalSpacer(Dimens.SpacingExtraSmall)
        }

        content()
    }
}