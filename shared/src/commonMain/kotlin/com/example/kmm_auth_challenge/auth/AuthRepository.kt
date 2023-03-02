package com.example.kmm_auth_challenge.auth

interface AuthRepository {

    fun login(phone: String, password: String)
    fun authenticate()
}