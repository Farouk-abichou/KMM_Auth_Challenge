package com.example.kmm_auth_challenge.android.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.auth.User
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    controller : MainController,
    navController: NavController
){

    val user = remember{ mutableStateOf(User("55529601", "123456789")) }

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
            value = user.value.phone,
            onValueChange = {
                user.value.phone
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = user.value.password,
            onValueChange = {
                user.value.password
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            scope.launch {
                text = try {
                    controller.getInfo(user.value.phone,user.value.password)
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