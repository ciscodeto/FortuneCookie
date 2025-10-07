package com.ciscodeto.fortunecookie.presentation.fortune

import com.ciscodeto.fortunecookie.domain.model.Fortune

sealed interface FortuneUiState {
    data object Idle : FortuneUiState
    data object Loading : FortuneUiState
    data class Success(val fortune: Fortune) : FortuneUiState
}
