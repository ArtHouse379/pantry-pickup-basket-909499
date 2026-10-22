package x1stsupermarket.grocery.pantrypickupbasket.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.cart.VKMODCartScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.checkout.VKMODCheckoutScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.home.VKMODHomeScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.onboarding.VKMODOnboardingScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.order.VKMODOrdersScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.productdetails.VKMODProductDetailsScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.settings.VKMODSettingsScreen
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.splash.VKMODSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            VKMODSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            VKMODOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            VKMODHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            VKMODProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            VKMODCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            VKMODCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            VKMODOrdersScreen()
        }

        composable<NavRoute.Settings> {
            VKMODSettingsScreen()
        }
    }
}