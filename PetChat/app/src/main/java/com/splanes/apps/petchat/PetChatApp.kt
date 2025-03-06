package com.splanes.apps.petchat

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun PetChatApp() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "" // TODO
  ) {

  }
}