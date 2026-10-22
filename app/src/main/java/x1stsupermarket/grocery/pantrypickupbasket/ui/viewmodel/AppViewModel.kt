package x1stsupermarket.grocery.pantrypickupbasket.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import x1stsupermarket.grocery.pantrypickupbasket.data.repository.CartRepository
import x1stsupermarket.grocery.pantrypickupbasket.ui.state.DataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val cartRepository: CartRepository,
) : ViewModel() {
    private val _cartPopulatedState =
        MutableStateFlow<DataUiState<Unit>>(DataUiState.Initial)
    val cartPopulatedState: StateFlow<DataUiState<Unit>>
        get() = _cartPopulatedState.asStateFlow()

    private val _itemsInCartState = MutableStateFlow<Int>(0)
    val itemsInCartState: StateFlow<Int>
        get() = _itemsInCartState.asStateFlow()

    init {
        observeCart()
    }

    private fun observeCart() {
        viewModelScope.launch {
            cartRepository.observeAll().collect { items ->
                _cartPopulatedState.update {
                    if (items.isNotEmpty()) {
                        DataUiState.Populated(Unit)
                    } else {
                        DataUiState.Empty
                    }
                }
                _itemsInCartState.update { items.sumOf { it.quantity } }
            }
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            cartRepository.deleteAll()
        }
    }
}