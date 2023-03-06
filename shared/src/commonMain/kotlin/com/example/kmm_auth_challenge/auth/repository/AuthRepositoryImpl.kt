package com.example.kmm_auth_challenge.auth.repository

import com.example.kmm_auth_challenge.auth.models.ErrorInfo
import com.example.kmm_auth_challenge.auth.models.LoginRespond
import com.example.kmm_auth_challenge.auth.models.TokenInfo
import com.example.kmm_auth_challenge.auth.models.User
import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class AuthRepositoryImpl(

) : AuthRepository {


    private var respond = LoginRespond("","","")

    private val bearerTokenStorage = mutableListOf<BearerTokens>()
    override suspend fun login(phone: String, password: String): LoginRespond {

        val client = HttpClient(CIO) {
            defaultRequest {
                url(BASE_URL)
            }
        }
        val response: HttpResponse = client.submitForm(
            url = LOGIN_URL,
            formParameters = Parameters.build {
                append("phone", phone)
                append("password", password)
            }
        )

        val obj = Json.decodeFromString<LoginRespond>(response.body())

        respond = LoginRespond(obj.status,obj.accessToken,obj.refreshToken)

        return obj
    }

    override suspend fun getRespond(phone: String, password: String) : User{
        val client = HttpClient(CIO) {
            defaultRequest {
                url(BASE_URL)
            }
        }
         HttpClient(CIO){
            defaultRequest {
                url(BASE_URL)
            }
            install(Auth){
                bearer {
                    loadTokens {
                        bearerTokenStorage.last()
                    }
                }
            }


         }
        var userInfo: User = User("","")
        val response: HttpResponse = client.get(BASE_URL)
        try {
            userInfo = response.body()



        } catch (e: Exception) {
            val errorInfo: ErrorInfo = response.body()
            println(errorInfo.error.message)
        }

        return  userInfo

    }

}