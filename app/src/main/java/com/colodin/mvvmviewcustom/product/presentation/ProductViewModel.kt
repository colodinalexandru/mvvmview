package com.colodin.mvvmviewcustom.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import com.colodin.mvvmviewcustom.product.domain.ProductProcessor
import com.colodin.mvvmviewcustom.product.domain.ProductResult
import com.colodin.mvvmviewcustom.product.domain.ProductState
import com.colodin.mvvmviewcustom.utilis.OneTimeEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 *
 * It is a little different from what you have found on the internet but this one will help to write unit and UI tests easier :p
 */

class ProductViewModel : ViewModel(), ProductResult, KoinComponent {

    private val productProcessor: ProductProcessor by inject()

    private val _uiState = MutableStateFlow(ProductState())
    val uiState: StateFlow<ProductState> = _uiState.asStateFlow()

    fun onProductActionInit() {
        viewModelScope.launch(Dispatchers.IO) {
            productProcessor.onProductActionInit(this@ProductViewModel)
        }
    }

    fun onProductActionFullProduct(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            productProcessor.onProductActionFullProduct(productId, this@ProductViewModel)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProductViewModel() as T
        }
    }

    override fun productResultItems(items: List<QAProductShort>) {
        _uiState.update { currentState ->
            currentState.copy(productItems = OneTimeEvent(items))
        }
    }

    override fun productShowProgress(showProgress: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(productShowProgress = OneTimeEvent(showProgress))
        }
    }

    override fun productErrorMessage(errorMessage: String) {
        _uiState.update { currentState ->
            currentState.copy(productErrorMessage = OneTimeEvent(errorMessage))
        }
    }

    override fun fullProduct(productFull: QAProductFull) {
        _uiState.update { currentState ->
            currentState.copy(fullProduct = OneTimeEvent(productFull))
        }
    }
}
