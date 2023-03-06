package com.example.kmm_auth_challenge.auth.models

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val code: Int,
    val payload: Payload,
    val status: String
)

@Serializable
data class Payload(
    val user: User
)

@Serializable
data class User(
    val _id: String,
    val avatar: String,
    val country: String,
    val countryCode: String,
    val countryData: CountryData,
    val currentStreak: Int,
    val dayEndsAfter: Int,
    val firstName: String,
    val inviteLink: String,
    val keywordsCount: Int,
    val lastName: String,
    val learningDuration: Int,
    val maxStreak: Int,
    val phone: String,
    val progress: List<String>,
    val verified: Boolean
)

@Serializable
data class CountryData(
    val ISOCode: String,
    val __v: Int,
    val _id: String,
    val code: String,
    val createdAt: String,
    val first: String,
    val flag: String,
    val isEmailRegistrationAvailable: Boolean,
    val isPhoneRegistrationAvailable: Boolean,
    val name: String,
    val updatedAt: String
)