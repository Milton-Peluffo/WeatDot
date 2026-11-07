package com.tomildev.weatdot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tomildev.weatdot.features.mainview.presentation.MainViewScreen
import com.tomildev.weatdot.ui.theme.WeatDotTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatDotTheme {
                MainViewScreen()
            }
        }
    }
}