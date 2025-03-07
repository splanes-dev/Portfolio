package com.splanes.apps.petchat.presentation.feature.auth.infrastructure.navigation

import kotlinx.serialization.Serializable

object AuthRoutes {

  @Serializable
  data object Auth

  @Serializable
  data object SignIn

  @Serializable
  data object SignUp
}