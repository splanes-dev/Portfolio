package com.splanes.apps.petchat.presentation.common.components.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class InputState(
  initialValue: String = "",
  private val supportingText: String = "",
) {
  var text by mutableStateOf(initialValue)
    private set

  var isError by mutableStateOf(false)
    private set

  var support by mutableStateOf(supportingText)
    private set

  fun onValueChanged(text: String) {
    this.text = text
    this.isError = false
    this.support = supportingText
  }

  fun onClear() {
    this.text = ""
    this.isError = false
    this.support = supportingText
  }

  fun validate(validation: (String) -> String?): Boolean {
    val err = validation(text)
    isError = err != null
    support = err ?: supportingText
    return err != null
  }
}

@Composable
fun rememberTextInputState(
  initialValue: String = "",
  supportingText: String = "",
)  = remember { InputState(initialValue, supportingText) }