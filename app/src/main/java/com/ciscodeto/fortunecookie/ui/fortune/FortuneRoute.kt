package com.ciscodeto.fortunecookie.ui.fortune

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ciscodeto.fortunecookie.presentation.fortune.FortuneViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FortuneRoute(
    modifier: Modifier = Modifier,
    viewModel: FortuneViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    FortuneScreen(
        state = uiState,
        onBreakCookie = viewModel::onBreakCookie,
        modifier = modifier
    )
}
