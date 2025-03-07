package com.splanes.apps.petchat.presentation.feature.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SignInViewModel : ViewModel() {

  private val viewModelState = MutableStateFlow(ViewModelState())

  val uiState: StateFlow<SignInUiState> = viewModelState
    .map { state -> state.toUiState() }
    .stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(5_000),
      initialValue = viewModelState.value.toUiState()
    )

  private data class ViewModelState(
    val isFullScreenLoading: Boolean = false,
    val isOverlayLoading: Boolean = false,
  ) {
    fun toUiState(): SignInUiState =
      when {
        isFullScreenLoading -> SignInUiState.Loading
        else -> SignInUiState.Ready(
          isLoading = isOverlayLoading,
          error = null // TODO
        )
      }
  }
}