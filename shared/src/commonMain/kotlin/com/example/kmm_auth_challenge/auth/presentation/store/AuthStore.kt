package com.example.kmm_auth_challenge.auth.presentation.store

import com.arkivanov.mvikotlin.core.store.Store
import com.example.kmm_auth_challenge.auth.presentation.store.AuthStore.*

interface AuthStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        object ShowData : Intent()
        data class AcceptUser( val phone: String,val password: String) : Intent()
    }

    data class State(
        val isValid: Boolean = false,
        val data: String = "Secret",
    )
}