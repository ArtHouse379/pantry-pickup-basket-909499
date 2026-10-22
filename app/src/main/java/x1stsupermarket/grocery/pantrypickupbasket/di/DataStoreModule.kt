package x1stsupermarket.grocery.pantrypickupbasket.di

import x1stsupermarket.grocery.pantrypickupbasket.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}