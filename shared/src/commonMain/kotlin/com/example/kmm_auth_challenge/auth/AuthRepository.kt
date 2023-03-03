package com.example.kmm_auth_challenge.auth

interface AuthRepository {

    suspend fun login(phone: String, password: String): LoginRespond

}