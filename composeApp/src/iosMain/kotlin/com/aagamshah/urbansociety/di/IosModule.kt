package com.aagamshah.urbansociety.di

import com.aagamshah.urbansociety.IOSDatabaseDriverFactory
import com.aagamshah.urbansociety.db.UrbanSocietyDatabase
import org.koin.dsl.module


val iosModule = module {

    single {
        IOSDatabaseDriverFactory().create()
    }

    single {
        UrbanSocietyDatabase(get())
    }
}
