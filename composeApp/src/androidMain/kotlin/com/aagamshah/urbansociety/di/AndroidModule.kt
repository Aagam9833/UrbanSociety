package com.aagamshah.urbansociety.di

import com.aagamshah.urbansociety.AndroidDatabaseDriverFactory
import com.aagamshah.urbansociety.db.UrbanSocietyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.koin.dsl.module

val androidModule = module {

    single {
        AndroidDatabaseDriverFactory(get()).create()
    }

    single {
        UrbanSocietyDatabase(get())
    }

    single<CoroutineScope> {
        MainScope()
    }

}
