package com.example.kmm_auth_challenge.android.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.kmm_auth_challenge.presentation.MainController


@Composable
fun SecretScreen (
    controller: MainController
){

    val state by controller.state.collectAsState()

    Column() {
        Text(text = state.toString())
    }

}