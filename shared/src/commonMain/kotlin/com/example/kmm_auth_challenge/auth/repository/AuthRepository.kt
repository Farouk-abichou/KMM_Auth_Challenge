package com.example.kmm_auth_challenge.auth.repository

import com.example.kmm_auth_challenge.auth.models.LoginRespond
import com.example.kmm_auth_challenge.auth.models.Login

interface AuthRepository {

    suspend fun login(phone: String, password: String): LoginRespond

    suspend fun getRespond(phone: String, password: String) : Login
}