package com.example.kmm_auth_challenge.auth.client

import com.example.kmm_auth_challenge.auth.models.*
import com.example.kmm_auth_challenge.data.accessToken
import com.example.kmm_auth_challenge.data.refreshToken
import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import com.example.kmm_auth_challenge.domain.REFRESH_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class AuthClient() {


    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(BASE_URL)
        }
    }

    suspend fun getAuthClient(bearerToken: BearerTokens): HttpClient {
        val authClient = client.config {
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(bearerToken.accessToken,bearerToken.refreshToken)
                    }
                    refreshTokens {
                        val getResponse: HttpResponse = client.get(urlString = REFRESH_URL) {
                            request {
                                setBody(
                                    mapOf(
                                        refreshToken to bearerToken.refreshToken
                                    )
                                )
                            }
                        }

                        val obj = Json.decodeFromString<Token>(getResponse.body())

                        BearerTokens(
                            accessToken = obj.accessToken,
                            refreshToken = obj.refreshToken
                        )
                    }
                }
            }
        }
        return authClient
    }

    suspend fun authentication(phone:String, password:String) : LoginRespond{
        val postResponse: HttpResponse = client.post(urlString = LOGIN_URL) {
            request {
                setBody(
                    mapOf(
                        "phone" to phone,
                        "password" to password,
                    )
                )
            }
        }

        val obj = Json.decodeFromString<LoginRespond>(postResponse.body())

        refreshToken.putString("refresh",obj.refreshToken)
        accessToken.putString("access",obj.accessToken)

        return obj
    }

}
