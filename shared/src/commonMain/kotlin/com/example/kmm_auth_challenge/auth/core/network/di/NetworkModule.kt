package com.example.kmm_auth_challenge.auth.core.network.di

import com.example.kmm_auth_challenge.auth.core.network.client.AuthClient
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: (enableLogging: Boolean) -> Module
    get() = { enableLogging ->
    module {
        single { createHttpClient(enableLogging) }
        single { AuthClient(client = get()) }
    }
}