package com.example.kmm_auth_challenge.auth


@kotlinx.serialization.Serializable

data class LoginRespond(
    val status : String? = null,
    val accessToken : String? = null,
    val refreshToken : String? = null
)