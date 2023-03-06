package com.example.kmm_auth_challenge.auth.repository

import com.example.kmm_auth_challenge.auth.models.*
import com.example.kmm_auth_challenge.data.Data
import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import com.example.kmm_auth_challenge.domain.USER_URL
import com.russhwolf.settings.get
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

    private val client = HttpClient(CIO) {
        defaultRequest {
            url(BASE_URL)
        }
    }

    fun authenticate(accessToken : String, refreshTokens : String){
        val authorizationClient = HttpClient(CIO) {
            defaultRequest {
                url(BASE_URL)
            }
            install(Auth){
                bearer {
                    loadTokens {
                        BearerTokens(accessToken,refreshTokens)
                    }
                    refreshTokens {
                        BearerTokens(accessToken,refreshTokens)
                    }
                }
            }
        }
    }







    override suspend fun login(phone: String, password: String): LoginRespond {

        val postResponse: HttpResponse = client.submitForm(
            url = LOGIN_URL,
            formParameters = Parameters.build {
                append("phone", phone)
                append("password", password)
            }
        )

        val obj = Json.decodeFromString<LoginRespond>(postResponse.body())

        Data().settings.putString("accessToken",obj.refreshToken.toString())

        return Json.decodeFromString(postResponse.body())
    }



    override suspend fun getRespond() : UserInfo {



        var refreshToken :String = ""

        val getRespond : HttpResponse = client.get(USER_URL){
            refreshToken = Data().settings["accessToken"]!!
            if (refreshToken != ""){
                bearerAuth(
                    refreshToken
                )
            }
            bearerAuth(
                try {
                     Data().settings["accessToken"]!!
                }catch (e: Exception){
                    e.toString()
                }
            )
        }
        val obj = Json.decodeFromString<UserInfo>(getRespond.body())
        Data().userInfoSettings.putString("Status",obj.status)

        return obj
    }
}
