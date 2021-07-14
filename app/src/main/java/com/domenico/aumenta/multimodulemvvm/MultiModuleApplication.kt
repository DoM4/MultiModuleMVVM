package com.domenico.aumenta.multimodulemvvm

import android.app.Application
import com.domenico.aumenta.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MultiModuleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MultiModuleApplication)
            modules(listOf(coreModule))
        }
    }
}