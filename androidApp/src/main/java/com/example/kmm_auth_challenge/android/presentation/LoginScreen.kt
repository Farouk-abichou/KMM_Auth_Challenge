package com.example.kmm_auth_challenge.android.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    controller : MainController,
    navController: NavController
){

    val phone = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }

    val state by controller.state.collectAsState()

    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Loading") }

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
            scope.launch {
                text = try {
                    controller.getInfo(phone.value,password.value)
                } catch (e: Exception) {
                    e.localizedMessage ?: "error"
                }
                if(text=="success"){
                    navController.navigate(
                        Routes.SECRET_SCREEN
                    )
                }
            }
        }) {
            Text("Login")
        }

        Text(text = text)
    }
}