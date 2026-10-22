package x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import x1stsupermarket.grocery.pantrypickupbasket.data.repository.OnboardingRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SplashViewModel(
    private val onboardingRepository: OnboardingRepository,
) : ViewModel() {

    val onboardedState: StateFlow<Boolean?> =
        onboardingRepository.observeOnboardingState()
            .map { it == true }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = null
            )
}
