package com.ciscodeto.fortunecookie.presentation.fortune

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciscodeto.fortunecookie.domain.usecase.GetRandomFortuneUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FortuneViewModel(
    private val getRandomFortune: GetRandomFortuneUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<FortuneUiState>(FortuneUiState.Idle)
    val uiState: StateFlow<FortuneUiState> = _uiState.asStateFlow()

    private var currentJob: Job? = null

    fun onBreakCookie() {
        if (_uiState.value is FortuneUiState.Loading) return

        currentJob?.cancel()
        currentJob = viewModelScope.launch {
            _uiState.value = FortuneUiState.Loading
            val fortune = getRandomFortune()
            _uiState.value = FortuneUiState.Success(fortune)
        }
    }
}
