package com.example.kmm_auth_challenge.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.essenty.instancekeeper.instanceKeeper
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = MainController(instanceKeeper() )

        val phone = mutableStateOf("")
        val password = mutableStateOf("")


        setContent {
            MyApplicationTheme {

                val state by controller.state.collectAsState()

                val scope = rememberCoroutineScope()
                var text by remember { mutableStateOf("Loading") }
                LaunchedEffect(true) {
                    scope.launch {
                        text = try {
                            controller.getInfo(phone.value,password.value)
                        } catch (e: Exception) {
                            e.localizedMessage ?: "error"
                        }
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 60.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text("Welcome")

                        TextField(value = phone.value, onValueChange = {
                            phone.value
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(value = password.value, onValueChange = {
                            password.value
                        })

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = {
                        }) {
                            Text("Login")
                        }
                        Text(text = text)
                    }
                }
            }
        }
    }
}

