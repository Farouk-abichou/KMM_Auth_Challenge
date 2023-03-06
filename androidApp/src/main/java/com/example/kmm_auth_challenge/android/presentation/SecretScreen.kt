package com.example.kmm_auth_challenge.android.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.presentation.MainController
import io.ktor.client.utils.EmptyContent.status
import kotlinx.coroutines.launch


@Composable
fun SecretScreen (
    controller: MainController
){
    //val state by controller.state.collectAsState()
    val scope = rememberCoroutineScope()


    val text = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        text.value = try {
//            controller.getRespond().toString()
//        } catch (e: Exception) {
//            e.localizedMessage ?: "error"
//        }
        LaunchedEffect(Unit){
            scope.launch {

                controller.getRespond("","")
            }

        }

        Text(text = text.value)
    }
}
