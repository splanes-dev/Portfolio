package com.splanes.apps.petchat.presentation.feature.auth.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SignInRoute(
  viewModel: SignInViewModel,
) {

  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  when (uiState) {
    SignInUiState.Loading ->
      SignInLoadingScreen()

    is SignInUiState.Ready ->
      SignInScreen()
  }
}