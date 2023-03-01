package com.example.kmm_auth_challenge.presentation.store

import com.arkivanov.mvikotlin.core.store.*
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.example.kmm_auth_challenge.presentation.store.CalculatorStore.*

internal class CalculatorStoreFactory(private val storeFactory: StoreFactory) {
    fun create(): CalculatorStore =
        object : CalculatorStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = "CounterStore",
            initialState = State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed interface Msg {
        data class verifyUser(val number: Long) : Msg
        data class Decremented(val number: Long) : Msg
    }

    private object ReducerImpl : Reducer<State, Msg> {
        override fun State.reduce(msg: Msg): State =
            when (msg) {
                is Msg.verifyUser -> copy(value = value + 1)
                is Msg.Decremented -> copy(value = value - 1)
            }
    }

    private inner class ExecutorImpl : CoroutineExecutor<Intent, Unit, State, Msg, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                is Intent.Increment -> dispatch(Msg.verifyUser(getState().value + 1))
                is Intent.Decrement -> dispatch(Msg.Decremented(getState().value - 1))
            }
    }
}