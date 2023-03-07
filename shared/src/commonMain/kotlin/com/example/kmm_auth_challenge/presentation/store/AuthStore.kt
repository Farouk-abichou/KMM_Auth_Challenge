package com.example.kmm_auth_challenge.presentation.store

import com.arkivanov.mvikotlin.core.store.Store
import com.example.kmm_auth_challenge.presentation.store.AuthStore.*

interface AuthStore : Store<Intent, State, Nothing> {

    sealed interface Intent {
        data class ShowError(val error : String) : Intent
        object GetData : Intent
        data class AcceptUser(val phone: String,val password: String) : Intent
    }

    data class State(
        val isValid: Boolean = false,
        val data: String = String()
    )
}