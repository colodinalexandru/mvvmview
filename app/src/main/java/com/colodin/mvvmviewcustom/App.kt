package com.colodin.mvvmviewcustom

import android.app.Application
import com.colodin.mvvmviewcustom.assay.initParser
import com.colodin.mvvmviewcustom.product.ProductModule
import com.colodin.mvvmviewcustom.repositories.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initParser(this,BuildConfig.PARSE_APPLICATION_ID)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger(level = Level.ERROR)
            }

            androidContext(this@App)
            modules(
                RepositoryModule,
                ProductModule,
            )
        }
    }
}