package com.example.kmm_auth_challenge.presentation

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.kmm_auth_challenge.presentation.store.AuthStoreFactory
import com.example.kmm_auth_challenge.domain.storeFactoryInstance
import com.example.kmm_auth_challenge.presentation.store.AuthStore
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.coroutineContext

class MainController(
    instanceKeeper: InstanceKeeper,
) {

    private val listStore =
        instanceKeeper.getStore {
            AuthStoreFactory(
                storeFactory = storeFactoryInstance,
            ).create()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    val state = listStore.stateFlow



     fun authenticate(phone:String, password: String) {
        listStore.accept(AuthStore.Intent.AcceptUser(phone,password))
    }

     fun getData() :String {
         return listStore.state.data
    }

}
