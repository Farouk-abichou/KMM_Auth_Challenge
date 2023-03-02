package com.example.kmm_auth_challenge.auth

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*

class AuthRepositoryImpl(

) {
    suspend fun getResponse(phone :String,password: String): String {

        val client = HttpClient(CIO){
            defaultRequest {
                url("https://api.lissene.com")
            }
        }
        val response: HttpResponse = client.submitForm(
            url = "/api/v2/auth/login",
            formParameters = Parameters.build {
                append("phone", phone)
                append("password", password)
            }
        )

        return response.body()
//            , accessToken = , refreshToken =
    }
}