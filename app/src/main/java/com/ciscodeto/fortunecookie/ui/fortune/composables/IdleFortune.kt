package com.ciscodeto.fortunecookie.ui.fortune.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
internal fun IdleFortune() {
    Text(
        text = "Tap the button to reveal your fortune.",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge
    )
}
