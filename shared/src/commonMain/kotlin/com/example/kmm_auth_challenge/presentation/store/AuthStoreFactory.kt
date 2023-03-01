package com.example.kmm_auth_challenge.presentation.store

import com.arkivanov.mvikotlin.core.store.*
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.example.kmm_auth_challenge.presentation.store.AuthStore.*

internal class AuthStoreFactory(private val storeFactory: StoreFactory) {
    fun create(): AuthStore =
        object : AuthStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = "AuthStore",
            initialState = State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}


    private sealed interface Msg {
        data class UserIsValid(val isValid: Boolean) : Msg
        data class UserIsNotValid(val isValid: Boolean) : Msg
    }

    private object ReducerImpl : Reducer<State, Msg> {
        override fun State.reduce(msg: Msg): State =
            when (msg) {
                is Msg.UserIsNotValid -> copy(isValid = false)
                is Msg.UserIsValid -> copy(isValid = true)
            }
    }

    private inner class ExecutorImpl : CoroutineExecutor<Intent, Unit, State, Msg, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                is Intent.AcceptUser -> dispatch(Msg.UserIsValid(true  ))
                is Intent.ShowError -> dispatch(Msg.UserIsValid(false  ))
            }
    }
}