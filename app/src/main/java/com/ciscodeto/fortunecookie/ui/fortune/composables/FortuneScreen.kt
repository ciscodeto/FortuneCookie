package com.ciscodeto.fortunecookie.ui.fortune.composables

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciscodeto.fortunecookie.domain.model.Fortune
import com.ciscodeto.fortunecookie.presentation.fortune.FortuneUiState
import com.ciscodeto.fortunecookie.ui.theme.FortuneCookieTheme

@Composable
fun FortuneScreen(
    state: FortuneUiState,
    onBreakCookie: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fortune Cookie",
            style = MaterialTheme.typography.headlineLarge
        )

        CookieImageButton(
            onClick = onBreakCookie,
            modifier = Modifier.size(140.dp)
        )

        Button(
            onClick = onBreakCookie,
            enabled = state !is FortuneUiState.Loading
        ) {
            Text(text = "Break cookie")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentAlignment = Alignment.Center
        ) {
            Crossfade(
                targetState = state,
                animationSpec = tween(durationMillis = 300),
                label = "fortune"
            ) { targetState ->
                when (targetState) {
                    FortuneUiState.Idle -> IdleFortune()
                    FortuneUiState.Loading -> CircularProgressIndicator()
                    is FortuneUiState.Success -> FortuneMessage(targetState.fortune.message)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FortuneScreenIdlePreview() {
    FortuneCookieTheme {
        FortuneScreen(
            state = FortuneUiState.Idle,
            onBreakCookie = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FortuneScreenSuccessPreview() {
    FortuneCookieTheme {
        FortuneScreen(
            state = FortuneUiState.Success(Fortune("Success is on its way.")),
            onBreakCookie = {}
        )
    }
}
