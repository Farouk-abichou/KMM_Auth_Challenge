package com.example.kmm_auth_challenge.android.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.delay


@Composable
fun SecretScreen (
    controller: MainController
){
    val data = remember{ mutableStateOf("") }

    LaunchedEffect( Unit){
        delay(2000)
        data.value = controller.state.value.data
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = data.value)
    }
}
