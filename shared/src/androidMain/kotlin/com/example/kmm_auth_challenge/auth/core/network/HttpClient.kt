package com.example.kmm_auth_challenge.auth.core.network

import io.ktor.client.*
import io.ktor.client.engine.android.*

actual fun createPlatformHttpClient(): HttpClient {
    return HttpClient(Android)
}