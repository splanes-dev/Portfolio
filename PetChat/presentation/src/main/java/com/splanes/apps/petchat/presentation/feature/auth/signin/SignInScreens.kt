package com.splanes.apps.petchat.presentation.feature.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.petchat.presentation.R
import com.splanes.apps.petchat.presentation.common.components.input.TextInput
import com.splanes.apps.petchat.presentation.common.theme.PetChatTheme

@Composable
fun SignInScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(color = PetChatTheme.colors.secondaryContainer)
      .padding(vertical = 24.dp, horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {

    Text(
      modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = 24.dp),
      text = "Pet Chat",
      style = PetChatTheme.typography.displayMedium,
      color = PetChatTheme.colors.onSecondaryContainer
    )

    Image(
      modifier = Modifier
        .size(150.dp)
        .align(Alignment.CenterHorizontally),
      painter = painterResource(R.drawable.petchat_logo),
      contentDescription = stringResource(R.string.app_name),
      colorFilter = ColorFilter.tint(PetChatTheme.colors.onSecondaryContainer)
    )

    Spacer(Modifier.height(16.dp))

    Text(
      text = "Sign in",
      style = PetChatTheme.typography.headlineMedium,
      color = PetChatTheme.colors.onSecondaryContainer
    )

    Text(
      text = "Please log in to continue",
      style = PetChatTheme.typography.bodyMedium,
      color = PetChatTheme.colors.onSecondaryContainer.copy(alpha = .7f)
    )

    TextInput(
      state = ,
      leadingIcon = Icons.Rounded.Email
    )

    TextInput(
      state = ,
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