package com.example.kmm_auth_challenge.auth



data class Login(
    val status : String? = null,
    val accessToken : String? = null,
    val refreshToken : String? = null
)