package com.splanes.apps.petchat.presentation.common.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.splanes.apps.petchat.presentation.common.theme.colors.AppColorScheme
import com.splanes.apps.petchat.presentation.common.theme.colors.DarkColorScheme
import com.splanes.apps.petchat.presentation.common.theme.colors.LightColorScheme
import com.splanes.apps.petchat.presentation.common.theme.typography.Typography

internal val LocalAppColorScheme = staticCompositionLocalOf<AppColorScheme> {
  error("No AppColorScheme provided")
}

object PetChatTheme {
  val colors: AppColorScheme
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColorScheme.current

  val typography: Typography
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography
}

@Composable
fun PetChatTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.background.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
  }

  CompositionLocalProvider(LocalAppColorScheme provides colorScheme) {
    MaterialTheme(
      colorScheme = colorScheme.toMaterialColorScheme(),
      typography = Typography,
      content = content
    )
  }
}