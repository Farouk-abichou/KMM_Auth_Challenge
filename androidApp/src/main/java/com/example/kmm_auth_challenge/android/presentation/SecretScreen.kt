package com.example.kmm_auth_challenge.android.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.launch


@Composable
fun SecretScreen (
    controller: MainController
){
    val data = remember{ mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect( Unit){
            data.value = controller.auth()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = data.value)
    }
}
