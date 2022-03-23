package com.example.rickandmortykotlin1

import android.app.Application
import com.example.rickandmortykotlin1.servicelocatior.networkModule
import com.example.rickandmortykotlin1.servicelocatior.repositoriesModule
import com.example.rickandmortykotlin1.servicelocatior.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, repositoriesModule, viewModelsModule)
        }
    }
}