package com.example.kmm_auth_challenge.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.arkivanov.essenty.instancekeeper.instanceKeeper
import com.example.kmm_auth_challenge.android.presentation.AuthRoot
import com.example.kmm_auth_challenge.auth.presentation.MainController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val controller = MainController(instanceKeeper() )
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AuthRoot(controller )
                }
            }
        }
    }
}

