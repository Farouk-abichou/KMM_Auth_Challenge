package com.example.kmm_auth_challenge.presentation

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.kmm_auth_challenge.presentation.store.AuthStore
import com.example.kmm_auth_challenge.presentation.store.AuthStoreFactory
import com.example.kmm_auth_challenge.domain.storeFactoryInstance
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

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





}

