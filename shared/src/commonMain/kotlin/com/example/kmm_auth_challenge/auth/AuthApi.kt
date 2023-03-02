package com.example.kmm_auth_challenge.auth

interface AuthApi {

    suspend fun login(
        request: AuthRequest
    ) : TokenResponse
}