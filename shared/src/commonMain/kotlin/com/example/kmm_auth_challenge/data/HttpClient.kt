package com.example.kmm_auth_challenge.data

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class HttpClient {

    suspend fun test(): String {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(" https://fakestoreapi.com/products/1")
        return response.status.toString()
    }
}