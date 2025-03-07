package com.splanes.apps.petchat.presentation.feature.auth.infrastructure.di

import com.splanes.apps.petchat.presentation.feature.auth.signin.SignInViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val AuthPresentationModule = module {
  viewModelOf(::SignInViewModel)
}