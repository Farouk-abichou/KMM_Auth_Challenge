package com.example.kmm_auth_challenge.presentation

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.kmm_auth_challenge.auth.models.UserInfo
import com.example.kmm_auth_challenge.auth.repository.AuthRepositoryImpl
import com.example.kmm_auth_challenge.data.Data
import com.example.kmm_auth_challenge.presentation.store.AuthStoreFactory
import com.example.kmm_auth_challenge.domain.storeFactoryInstance
import com.russhwolf.settings.get
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainController(
    instanceKeeper: InstanceKeeper,
) {
    private val repository = AuthRepositoryImpl()

    private val listStore =
        instanceKeeper.getStore {
            AuthStoreFactory(
                storeFactory = storeFactoryInstance,
            ).create()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    val state = listStore.stateFlow


    suspend fun getInfo(phone:String, password: String): String {
        return repository.login(
            phone =phone,
            password = password
        ).status
    }
     suspend fun getRespond(): UserInfo {
        return repository.getRespond()
    }

     fun checkToken() : Boolean{
        return Data().userInfoSettings.toString() != ""
    }
}
