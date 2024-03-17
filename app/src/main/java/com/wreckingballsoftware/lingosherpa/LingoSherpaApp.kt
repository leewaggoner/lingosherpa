package com.wreckingballsoftware.lingosherpa

import android.app.Application
import com.wreckingballsoftware.lingosherpa.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LingoSherpaApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@LingoSherpaApp)
            modules(appModule)
        }
    }
}