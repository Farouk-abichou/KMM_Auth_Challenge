package com.example.kmm_auth_challenge.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.essenty.instancekeeper.instanceKeeper
import com.example.kmm_auth_challenge.data.HttpClient
import com.example.kmm_auth_challenge.presentation.MainController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = MainController(instanceKeeper() )

        var text = ""
        suspend {
            text =HttpClient().test()
        }


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
                            text = text,
                            Modifier.padding(10.dp)
                        )
                        Text(
                            text = "text",
                            Modifier.padding(10.dp)
                        )

                        TextField(value = "", onValueChange = {
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(value = "", onValueChange = {})

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = {
                        }) {
                            Text("Login")
                        }
                    }
                }
            }
        }
    }
}

