package com.tomildev.weatdot.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.tomildev.weatdot.R
import com.tomildev.weatdot.core.presentation.components.texts.Texts
import com.tomildev.weatdot.ui.theme.Alpha

object Dialogs {

    @Composable
    fun AppDialogInfo(
        title: String = "",
        message: String = "",
        dismissText: String = stringResource(R.string.common_text_confirm),
        onDismiss: () -> Unit,
    ) {
        Base(
            title = title,
            message = message,
            dismissText = dismissText,
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun Base(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    confirmText: String = "",
    dismissText: String = "",
    isWarning: Boolean = false,
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
) {

    val rippleColor =
        if (isWarning) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary

    AlertDialog(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
        onDismissRequest = { onDismiss() },
        title = {
            Texts.TitleMedium(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        text = {
            Texts.Body(
                modifier = Modifier.fillMaxWidth(),
                text = message,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = Alpha.AlphaHigh)
            )
        },
        confirmButton = {
            TextButton(
                onClick = onConfirm,
                colors = ButtonDefaults.textButtonColors(contentColor = rippleColor)
            ) {
                Texts.LabelMedium(
                    text = confirmText,
                    color = rippleColor
                )
            }

        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Texts.LabelMedium(
                    text = dismissText,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
    )
}