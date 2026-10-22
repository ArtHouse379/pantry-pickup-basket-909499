package x1stsupermarket.grocery.pantrypickupbasket.di

import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.AppViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.CartViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.CheckoutViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.OnboardingViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.OrderViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.ProductDetailsViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.ProductViewModel
import x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}