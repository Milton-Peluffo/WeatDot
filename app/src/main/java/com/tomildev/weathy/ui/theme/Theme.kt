package com.tomildev.weathy.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = White100, //Buttons
    onPrimary = Black0, //on buttons or chips

    background = Black0, //Screen background
    onBackground = White100,

    surface = Black0, //Screen background
    onSurface = White100, //Texts or icons on screen background

    surfaceContainer = Black10, //Card / Box / or any container
    surfaceContainerHighest = Black20, //TextFields, Dialogs or any other field that needs a high elevation
    surfaceContainerHigh = Black10, //BottomSheet
    surfaceVariant = Black30, // Other surface variant for componentes with a lot of elevation

    inverseSurface = Black20, //Snackbars
    inversePrimary = Black0, //Texts that are dark in light and dark theme

    outlineVariant = Gray100, //Outline or borders
    error = Error //Errors
)

private val LightColorScheme = lightColorScheme(
    primary = Black0, //on buttons or chips
    onPrimary = White100, //on buttons

    background = White100, //Screen background (Fondo blanco puro sin tinte rosado)
    onBackground = Black0,

    surface = White100, //Screen background (White100 = #FDFDFD)
    onSurface = Black0, //Texts or icons on screen background

    surfaceContainer = White100, //Card / Box / or any container
    surfaceContainerHighest = White100, //TextFields, Dialogs or any other field that needs a high elevation
    surfaceContainerHigh = White90, //BottomSheet
    surfaceVariant = White80, // Other surface variant for componentes with a lot of elevation

    inverseSurface = White100, //Snackbars
    inversePrimary = Black0, //Texts that are dark in light and dark theme

    outlineVariant = Black60, //Outline or borders
    error = Error //Errors
)

@Composable
fun WeathyTheme(
    //darkTheme: Boolean = isSystemInDarkTheme(),
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }


    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}
