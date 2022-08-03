package com.baudelio.test.macropay.application

import android.app.Application
import com.baudelio.test.home.di.homeModule
import com.baudelio.test.login.di.loginModule
import org.koin.core.context.startKoin

class MacroPayTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                loginModule,
                homeModule
            )
        }
    }
}