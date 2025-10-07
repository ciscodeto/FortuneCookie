package com.ciscodeto.fortunecookie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ciscodeto.fortunecookie.ui.fortune.FortuneRoute
import com.ciscodeto.fortunecookie.ui.theme.FortuneCookieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FortuneCookieTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FortuneRoute()
                }
            }
        }
    }
}
