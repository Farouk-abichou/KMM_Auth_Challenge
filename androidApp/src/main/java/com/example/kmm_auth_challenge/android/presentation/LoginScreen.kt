package com.example.kmm_auth_challenge.android.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.auth.presentation.MainController
import kotlinx.coroutines.delay


@Composable
fun LoginScreen(
    controller : MainController,
    navController: NavController
){

    val state = controller.state.collectAsState()
    val phone = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }
    val status = remember { mutableStateOf("Loading") }
    val data = remember{ mutableStateOf("") }

    LaunchedEffect(Unit){
        controller.getData()
        delay(2000)
        data.value = controller.state.value.data
        if (data.value.length >100){
            navController.navigate(
                Routes.SECRET_SCREEN
            )
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 60.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Welcome")

        TextField(
            value = phone.value,
            onValueChange = {
                phone.value = it
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            controller.authenticate(
                phone.value,
                password.value
            )
            if (state.value.isValid){
                controller.getData()
                navController.navigate(
                    Routes.SECRET_SCREEN
                )
            }
        }) {
            Text("Login")
        }

        if (status.value == "success"){
            Text(text = "Welcome Back")
        }else if (status.value !=""){
            Log.d("tag",status.value)
            Text(text = "Enter valid Password ")
        }
    }
}