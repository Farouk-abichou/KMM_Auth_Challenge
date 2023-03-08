package com.example.kmm_auth_challenge.auth.core.models


@kotlinx.serialization.Serializable

data class LoginRespond(
    val status : String,
    val accessToken : String,
    val refreshToken : String
)