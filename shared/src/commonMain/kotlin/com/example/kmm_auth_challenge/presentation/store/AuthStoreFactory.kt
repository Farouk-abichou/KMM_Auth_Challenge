package com.example.kmm_auth_challenge.presentation.store

import com.arkivanov.mvikotlin.core.store.*
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.example.kmm_auth_challenge.auth.client.AuthClient
import com.example.kmm_auth_challenge.presentation.store.AuthStore.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class AuthStoreFactory(
    private val storeFactory: StoreFactory
    ) {
    private val client: AuthClient = AuthClient()
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
         class GetData(val data: String) : Msg
    }

    private object ReducerImpl : Reducer<State, Msg> {
        override fun State.reduce(msg: Msg): State =
            when (msg) {
                is Msg.UserIsValid -> copy(isValid = isValid)
                is Msg.GetData ->  copy(data = msg.data)
            }
    }

    private inner class ExecutorImpl : CoroutineExecutor<Intent, Unit, State, Msg, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                is Intent.AcceptUser -> authenticate(intent.phone,intent.password)
                is Intent.ShowData -> getData()
            }

        private fun authenticate(phone:String, password: String) {
             scope.launch{
                 dispatch(
                     Msg.UserIsValid( client.authentication(phone,password).status =="success")
                 )
             }
         }

        private fun getData()  {
             scope.launch {
                 val data = withContext(Dispatchers.Default) { "texttt" }

                 dispatch(
                    Msg.GetData("aaaaaaaaa")
                )
             }
        }
    }
}

