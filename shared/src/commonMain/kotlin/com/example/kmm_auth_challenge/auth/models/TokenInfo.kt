package com.example.kmm_auth_challenge.auth.models

import kotlinx.serialization.*

@Serializable
data class Token(
    @SerialName("access_token") val accessToken: String,
    @SerialName("refresh_token") val refreshToken: String,
)