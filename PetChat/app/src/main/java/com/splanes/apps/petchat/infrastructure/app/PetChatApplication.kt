package com.splanes.apps.petchat.infrastructure.app

import android.app.Application
import com.splanes.apps.petchat.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class PetChatApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidLogger(
        level = if (BuildConfig.Debug) {
          Level.DEBUG
        } else {
          Level.INFO
        }
      )
      androidContext(this@PetChatApplication)
      modules(koinModules())
    }
  }

  private fun koinModules(): List<Module> = listOf(

  )
}