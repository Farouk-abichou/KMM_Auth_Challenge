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
import com.example.kmm_auth_challenge.auth.TokenResponse
import com.example.kmm_auth_challenge.presentation.MainController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = MainController(instanceKeeper() )




        setContent {
            MyApplicationTheme {

                val state by controller.state.collectAsState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    val scope = rememberCoroutineScope()
                    var text by remember { mutableStateOf("Loading") }
                    LaunchedEffect(true) {
                        scope.launch {
                            text = try {
                                controller.getInfo("55529601","123456789")
                            } catch (e: Exception) {
                                e.localizedMessage ?: "error"
                            }
                        }
                    }

                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 60.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(text)

//                        TextField(value = "", onValueChange = {
//                        })
//                        Spacer(modifier = Modifier.height(8.dp))
//                        TextField(value = "", onValueChange = {})
//
//                        Spacer(modifier = Modifier.height(8.dp))
//
//                        Button(onClick = {
//                        }) {
//                            Text("Login")
//                        }
                    }
                }
            }
        }
    }
}

