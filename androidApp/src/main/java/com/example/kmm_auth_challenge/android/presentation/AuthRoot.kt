package com.example.kmm_auth_challenge.android.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmm_auth_challenge.android.core.presentation.Routes
import com.example.kmm_auth_challenge.auth.presentation.MainController

@Composable
fun AuthRoot(
    controller: MainController
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(route = Routes.LOGIN){
            LoginScreen(
                controller,
                navController
            )
        }
        composable(
            route = Routes.SECRET_SCREEN,
        ) {
            SecretScreen(controller)
        }
    }
}
