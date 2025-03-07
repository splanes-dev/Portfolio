package com.splanes.apps.petchat.presentation.common.components.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import com.splanes.apps.petchat.presentation.common.theme.PetChatTheme

@Composable
fun TextInput(
  state: InputState,
  modifier: Modifier = Modifier,
  leadingIcon: ImageVector? = null,
  label: String = "",
  cleanable: Boolean = true,
  trailingIcon: (@Composable () -> Unit)? = null,
  enabled: Boolean = true,
  visualTransformation: VisualTransformation = VisualTransformation.None,
  keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
  keyboardActions: KeyboardActions = KeyboardActions.Default,
  singleLine: Boolean = false,
  maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
  minLines: Int = 1,
) {
  var isFocused by remember { mutableStateOf(false) }

  TextField(
    modifier = modifier.onFocusEvent { focusState ->
      isFocused = focusState.isFocused
    },
    value = state.text,
    onValueChange = state::onValueChanged,
    label = label
      .takeUnless { it.isBlank() }
      ?.let {
        {
          Text(text = label)
        }
      },
    leadingIcon = leadingIcon?.let {
      {
        Icon(
          imageVector = leadingIcon,
          contentDescription = label,
          tint = when {
            state.isError -> PetChatTheme.colors.error
            isFocused -> PetChatTheme.colors.primary
            else -> PetChatTheme.colors.onSurface
          }.copy(alpha = .7f)
        )
      }
    },
    trailingIcon = when {
      trailingIcon != null -> trailingIcon
      cleanable -> {
        {
          AnimatedVisibility(
            visible = state.text.isNotBlank(),
            enter = fadeIn(),
            exit = fadeOut()
          ) {
            IconButton(onClick = state::onClear) {
              Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Clear",
                tint = when {
                  state.isError -> PetChatTheme.colors.error
                  isFocused -> PetChatTheme.colors.primary
                  else -> PetChatTheme.colors.onSurface
                }.copy(alpha = .5f),
              )
            }
          }
        }
      }

      else -> null
    },
    supportingText = state.support
      .takeUnless { it.isBlank() }
      ?.let { support ->
        {
          Text(
            text = support,
            color = when {
              state.isError -> PetChatTheme.colors.error
              isFocused -> PetChatTheme.colors.primary
              else -> PetChatTheme.colors.onSurface
            }.copy(alpha = .7f)
          )
        }
      },
    enabled = enabled,
    isError = state.isError,
    visualTransformation = visualTransformation,
    keyboardActions = keyboardActions,
    keyboardOptions = keyboardOptions,
    maxLines = maxLines,
    minLines = minLines,
    singleLine = singleLine,
    colors = TextFieldDefaults.colors(
      disabledIndicatorColor = Color.Transparent,
      errorIndicatorColor = Color.Transparent,
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
    ),
    shape = MaterialTheme.shapes.small
  )
}
