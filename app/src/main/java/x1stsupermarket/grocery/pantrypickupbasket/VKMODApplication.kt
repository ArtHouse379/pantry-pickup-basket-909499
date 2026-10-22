package x1stsupermarket.grocery.pantrypickupbasket

import android.app.Application
import x1stsupermarket.grocery.pantrypickupbasket.di.dataModule
import x1stsupermarket.grocery.pantrypickupbasket.di.dispatcherModule
import x1stsupermarket.grocery.pantrypickupbasket.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class VKMODApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@VKMODApplication)
            modules(appModules)
        }
    }
}
