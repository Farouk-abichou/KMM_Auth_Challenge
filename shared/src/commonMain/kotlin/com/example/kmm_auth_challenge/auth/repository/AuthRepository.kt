package com.example.kmm_auth_challenge.auth.repository

import com.example.kmm_auth_challenge.auth.models.LoginRespond

interface AuthRepository {

    suspend fun login(phone: String, password: String): LoginRespond

    fun getRespond()
}