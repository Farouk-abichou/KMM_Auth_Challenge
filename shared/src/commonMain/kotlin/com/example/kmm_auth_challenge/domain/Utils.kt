package com.example.kmm_auth_challenge.domain

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory

val storeFactoryInstance: StoreFactory = DefaultStoreFactory()

const val BASE_URL = "https://api.lissene.com"
const val LOGIN_URL = "/api/v2/auth/login"
const val REFRESH_URL = "/api/v2/auth/refresh"
const val USER_URL = "/api/v2/user/me"
