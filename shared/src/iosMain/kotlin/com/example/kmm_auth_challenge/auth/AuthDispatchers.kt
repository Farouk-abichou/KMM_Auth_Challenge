package com.example.kmm_auth_challenge.auth

import com.example.kmm_auth_challenge.auth.AuthDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val authDispatchers: AuthDispatchers = object: AuthDispatchers {
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.Default
    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}