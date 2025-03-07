package com.splanes.apps.petchat.presentation.feature.auth.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.splanes.apps.petchat.presentation.common.theme.PetChatTheme

@Composable
fun SignInScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(color = PetChatTheme.colors.surface)
      .padding(vertical = 24.dp, horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "Sign in",
      style = PetChatTheme.typography.headlineMedium,
      color = PetChatTheme.colors.onSurface
    )

    Text(
      text = "Please log in to continue",
      style = PetChatTheme.typography.bodyMedium,
      color = PetChatTheme.colors.onSurface.copy(alpha = .7f)
    )
  }
}

@Composable
fun SignInLoadingScreen() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = PetChatTheme.colors.surface),
    contentAlignment = Alignment.Center
  ) {
    CircularProgressIndicator(color = PetChatTheme.colors.primary)
  }
}