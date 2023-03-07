package com.example.kmm_auth_challenge.auth.client

import com.example.kmm_auth_challenge.auth.models.*
import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import com.example.kmm_auth_challenge.domain.USER_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class AuthClient() {

    private val bearerTokenStorage = mutableListOf<BearerTokens>()

    private val client = HttpClient(CIO) {
        defaultRequest {
            url(BASE_URL)
        }
    }

    suspend fun authentication(phone:String, password:String) : LoginRespond{
        val postResponse: HttpResponse = client.submitForm(
            url = LOGIN_URL,
            formParameters = Parameters.build {
                append("phone", phone)
                append("password", password)
            }
        )
        val obj = Json.decodeFromString<LoginRespond>(postResponse.body())

        bearerTokenStorage.add(BearerTokens(obj.accessToken,obj.refreshToken))

        return obj
    }


    suspend fun authorization(phone:String, password:String){
        val authorizationClient=HttpClient(CIO) {
             install(ContentNegotiation) {
                json()
            }
            defaultRequest {
                url(BASE_URL)
            }
            install(Auth){
                bearer {
                    loadTokens {
                        bearerTokenStorage.last()
                    }
                    refreshTokens {
                        val refreshTokenInfo: TokenInfo = client.submitForm(
                            url = BASE_URL,
                            formParameters = Parameters.build {
                                append("phone", phone)
                                append("password", password)
                            }
                        ) { markAsRefreshTokenRequest() }.body()
                        bearerTokenStorage.add(BearerTokens(refreshTokenInfo.accessToken, oldTokens?.refreshToken!!))
                        bearerTokenStorage.last()
                    }

                }
            }
        }
        val response = authorizationClient.get(USER_URL){
            bearerAuth(
                bearerTokenStorage.last().refreshToken
            )
        }

        println(response.status.value)

    }


//    override suspend fun login(phone: String, password: String): LoginRespond {
//
//        val postResponse: HttpResponse = client.submitForm(
//            url = LOGIN_URL,
//            formParameters = Parameters.build {
//                append("phone", phone)
//                append("password", password)
//            }
//        )
//        val obj = Json.decodeFromString<LoginRespond>(postResponse.body())
//        bearerTokenStorage.add(BearerTokens(obj.accessToken,obj.refreshToken))
//
//        return obj
//    }
//
//    override suspend fun getRespond() : UserInfo {
//
//
//        authenticate()
//
//
//        val getRespond : HttpResponse = client.get(USER_URL){
//            bearerAuth()
//        }
//        val obj = Json.decodeFromString<UserInfo>(getRespond.body())
//        Data().userInfoSettings.putString("Status",obj.status)
//
//        return obj
//    }
}
