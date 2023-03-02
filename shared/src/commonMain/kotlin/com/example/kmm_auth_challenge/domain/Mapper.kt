package com.example.kmm_auth_challenge.domain

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TokenDto(
    @SerialName("status") val status: String,
    @SerialName("accessToken") val accessToken: String,
    @SerialName("refreshToken") val refreshToken: String
)
