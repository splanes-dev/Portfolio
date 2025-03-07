package com.splanes.apps.petchat

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.splanes.apps.petchat.presentation.feature.auth.infrastructure.navigation.AuthRoutes
import com.splanes.apps.petchat.presentation.feature.auth.infrastructure.navigation.authNavGraph

@Composable
fun PetChatApp() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = AuthRoutes.Auth
  ) {
    authNavGraph()
  }
}