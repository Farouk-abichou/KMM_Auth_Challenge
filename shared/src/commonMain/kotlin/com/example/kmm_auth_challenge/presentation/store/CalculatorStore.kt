package com.example.kmm_auth_challenge.presentation.store

import com.arkivanov.mvikotlin.core.store.Store
import com.example.kmm_auth_challenge.presentation.store.CalculatorStore.*

interface CalculatorStore : Store<Intent, State, Nothing> {

    sealed interface Intent {
        object Increment : Intent
        object Decrement : Intent
    }

    data class State(
        var value: Long = 0
    )
}