package com.splanes.apps.petchat.presentation.common.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.splanes.apps.petchat.presentation.R

private val baseline = Typography()
private val displayFontFamily: FontFamily = FontFamily(
  Font(resId = R.font.poiret_one_regular),
)
private val bodyFontFamily: FontFamily = FontFamily(
  Font(resId = R.font.product_sans_regular),
  Font(resId = R.font.product_sans_bold, weight = FontWeight.Bold),
  Font(resId = R.font.product_sans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
  Font(resId = R.font.product_sans_italic, style = FontStyle.Italic),
  Font(resId = R.font.product_sans_light, weight = FontWeight.Light),
  Font(
    resId = R.font.product_sans_light_italic,
    weight = FontWeight.Light,
    style = FontStyle.Italic
  ),
)

internal val Typography = Typography(
  displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
  displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
  displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
  headlineLarge = baseline.headlineLarge.copy(fontFamily = bodyFontFamily),
  headlineMedium = baseline.headlineMedium.copy(fontFamily = bodyFontFamily),
  headlineSmall = baseline.headlineSmall.copy(fontFamily = bodyFontFamily),
  titleLarge = baseline.titleLarge.copy(fontFamily = bodyFontFamily),
  titleMedium = baseline.titleMedium.copy(fontFamily = bodyFontFamily),
  titleSmall = baseline.titleSmall.copy(fontFamily = bodyFontFamily),
  bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
  bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
  bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
  labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
  labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
  labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)