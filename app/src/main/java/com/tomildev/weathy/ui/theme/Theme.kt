package com.tomildev.weathy.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = White100, // Buttons
    onPrimary = Black0, // On buttons or chips

    secondary = RedColor,

    background = Black0, // Screen background
    onBackground = White100,

    surface = Black0, // Screen background
    onSurface = White100, // Texts or icons on screen background

    surfaceContainer = Black10, // Card / Box / or any container
    surfaceContainerHighest = Black10, // TextFields, Dialogs or any other field that needs a high elevation
    surfaceContainerHigh = Black20, // BottomSheet
)

@Composable
fun WeathyTheme(
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            dynamicDarkColorScheme(LocalContext.current)
        }

        else -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}