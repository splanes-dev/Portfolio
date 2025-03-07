package com.splanes.apps.petchat.presentation.feature.auth.infrastructure.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.splanes.apps.petchat.presentation.feature.auth.signin.SignInRoute
import com.splanes.apps.petchat.presentation.feature.auth.signin.SignInViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.authNavGraph() {

  navigation<AuthRoutes.Auth>(startDestination = AuthRoutes.SignIn) {
    composable<AuthRoutes.SignIn> {
      val viewModel = koinViewModel<SignInViewModel>()
      SignInRoute(
        viewModel = viewModel,
      )
    }

    composable<AuthRoutes.SignUp> {

    }
  }
}