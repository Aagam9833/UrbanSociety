package com.aagamshah.urbansociety

import android.app.Application
import com.aagamshah.urbansociety.di.androidModule
import com.aagamshah.urbansociety.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class UrbanSocietyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UrbanSocietyApp)
            modules(
                commonModule,
                androidModule
            )
        }
    }
}
