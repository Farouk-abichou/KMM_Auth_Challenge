package com.example.kmm_auth_challenge.auth.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs : Boolean =false, appDeclaration: KoinAppDeclaration ={}) =
    startKoin {
        appDeclaration()
        modules(

        )
    }
