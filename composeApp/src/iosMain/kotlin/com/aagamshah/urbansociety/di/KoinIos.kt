package com.aagamshah.urbansociety.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            commonModule,
            iosModule
        )
    }
}
