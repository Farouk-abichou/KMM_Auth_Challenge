package com.example.kmm_auth_challenge.auth.models


@kotlinx.serialization.Serializable

data class LoginRespond(
    val status : String,
    val accessToken : String? = null,
    val refreshToken : String? = null
)