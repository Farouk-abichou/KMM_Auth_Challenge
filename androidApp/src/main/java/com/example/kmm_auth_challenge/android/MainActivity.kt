package com.example.kmm_auth_challenge.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.essenty.instancekeeper.instanceKeeper
import com.example.kmm_auth_challenge.MainController

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
                    Row(
                        Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = {
                            controller.onIncrementNumber()
                        }) {
                            Text("+")
                        }

                        Text(
                            text = " ${state.value} ",

                            Modifier.padding(10.dp)
                        )

                        Button(onClick = {
                            controller.onDecrementNumber()
                        }) {
                            Text("-")
                        }
                    }
                }
            }
        }
    }
}

