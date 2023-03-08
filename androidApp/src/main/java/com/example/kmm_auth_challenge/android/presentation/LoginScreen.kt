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
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.presentation.MainController


@Composable
fun LoginScreen(
    controller : MainController,
    navController: NavController
){

    val store = MainController(InstanceKeeperDispatcher())

    val phone = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }
    val status = remember { mutableStateOf("Loading") }

    LaunchedEffect(Unit){
        if (store.state.data.length >200){
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
                "55529601",
                "123456789"
            )
            if (store.state.isValid){
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