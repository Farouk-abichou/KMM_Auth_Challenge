package com.example.kmm_auth_challenge.auth

import com.example.kmm_auth_challenge.domain.BASE_URL
import com.example.kmm_auth_challenge.domain.LOGIN_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.DataConversion.install
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class AuthRepositoryImpl(

) :AuthRepository{


    private var respond = LoginRespond("","","")
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

    override fun getRespond(){
         HttpClient(CIO){
            defaultRequest {
                url(BASE_URL)
            }
            install(Auth){
                bearer {
                    loadTokens {
                        BearerTokens(respond.accessToken.toString(),respond.refreshToken.toString())
                    }
                }
            }
        }

    }

}