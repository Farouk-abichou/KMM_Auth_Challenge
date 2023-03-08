package com.example.kmm_auth_challenge.auth

import kotlinx.coroutines.CoroutineDispatcher

interface AuthDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val authDispatchers: AuthDispatchers