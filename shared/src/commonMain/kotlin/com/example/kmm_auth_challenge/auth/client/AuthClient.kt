package com.example.kmm_auth_challenge.auth.client

import com.example.kmm_auth_challenge.auth.models.*
import com.example.kmm_auth_challenge.data.accessTokenData
import com.example.kmm_auth_challenge.data.refreshTokenData
import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import com.example.kmm_auth_challenge.domain.REFRESH_URL
import com.example.kmm_auth_challenge.domain.USER_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
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

        request {
            contentType(ContentType.Application.Json)
        }
    }
    suspend fun authentication(phone: String, password: String): LoginRespond {
        val postResponse: HttpResponse = client.post(urlString = LOGIN_URL) {
            contentType(ContentType.Application.Json)
            setBody(
                hashMapOf(
                    "phone" to phone,
                    "password" to password,
                )
            )
        }

        val obj = Json.decodeFromString<LoginRespond>(postResponse.body())

        accessTokenData.putString("accessToken",obj.accessToken)
        refreshTokenData.putString("refreshToken",obj.refreshToken)

        return obj
    }
    suspend fun getData(): String {

        val getResponse: HttpResponse =
            getAuthClient().get(urlString = USER_URL) {
                contentType(ContentType.Application.Json)
                bearerAuth(
                    refreshTokenData.getString("refreshToken","")
                )
        }
        return getResponse.body<String>().toString()
    }
    private suspend fun getAuthClient(): HttpClient {
        val authClient = client.config {
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            accessTokenData.getString("accessToken",""),
                            refreshTokenData.getString("refreshToken",""),
                        )
                    }
                    refreshTokens {
                        val getResponse: HttpResponse = client.get(urlString = REFRESH_URL) {
                            request {
                                bearerAuth(
                                    refreshTokenData.getString("refreshToken",""),
                                )
                            }
                        }
                        val obj = Json.decodeFromString<Token>(getResponse.body())
                        accessTokenData.putString("accessToken",obj.accessToken)
                        refreshTokenData.putString("refreshToken",obj.refreshToken)


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
}
