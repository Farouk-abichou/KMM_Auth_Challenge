package com.example.kmm_auth_challenge.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.essenty.instancekeeper.instanceKeeper
import com.example.kmm_auth_challenge.presentation.MainController
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.http.*

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
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 60.dp),
                        verticalArrangement = Arrangement.Center
                    ) {


                        Text(
                            text = " Welcome ",
                            Modifier.padding(10.dp)
                        )

                        TextField(value = "", onValueChange = {
                            state.
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(value = "", onValueChange = {})

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = {
                            controller.onDecrementNumber()
                        }) {
                            Text("Login")
                        }
                    }
                }
            }
        }
    }
}

