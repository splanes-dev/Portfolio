package com.splanes.apps.petchat.presentation.feature.auth.signin

sealed interface SignInUiState {
  data object Loading : SignInUiState
  data class Ready(
    val isLoading: Boolean,
    val error: Any? // TODO
  ) : SignInUiState
}