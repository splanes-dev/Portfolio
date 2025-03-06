package com.splanes.apps.petchat

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.splanes.apps.petchat.presentation.common.theme.PetChatTheme

class PetChatActivity : FragmentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      PetChatTheme {
        PetChatApp()
      }
    }
  }
}