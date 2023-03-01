package com.example.kmm_auth_challenge.presentation

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.kmm_auth_challenge.presentation.store.CalculatorStore
import com.example.kmm_auth_challenge.presentation.store.CalculatorStoreFactory
import com.example.kmm_auth_challenge.domain.storeFactoryInstance
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainController(
    instanceKeeper: InstanceKeeper,

) {
    private val listStore =
        instanceKeeper.getStore {
            CalculatorStoreFactory(
                storeFactory = storeFactoryInstance,
            ).create()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    val state = listStore.stateFlow

    fun onIncrementNumber() {
        listStore.accept(CalculatorStore.Intent.Increment)
    }

    fun onDecrementNumber() {
        listStore.accept(CalculatorStore.Intent.Decrement)
    }
}