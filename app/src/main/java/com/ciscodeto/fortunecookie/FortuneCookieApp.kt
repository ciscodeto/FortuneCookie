package com.ciscodeto.fortunecookie

import android.app.Application
import com.ciscodeto.fortunecookie.di.dataModule
import com.ciscodeto.fortunecookie.di.domainModule
import com.ciscodeto.fortunecookie.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FortuneCookieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FortuneCookieApp)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}
