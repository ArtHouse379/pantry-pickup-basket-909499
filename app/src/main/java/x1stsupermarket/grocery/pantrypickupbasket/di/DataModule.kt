package x1stsupermarket.grocery.pantrypickupbasket.di

import x1stsupermarket.grocery.pantrypickupbasket.data.repository.CartRepository
import x1stsupermarket.grocery.pantrypickupbasket.data.repository.OnboardingRepository
import x1stsupermarket.grocery.pantrypickupbasket.data.repository.OrderRepository
import x1stsupermarket.grocery.pantrypickupbasket.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}