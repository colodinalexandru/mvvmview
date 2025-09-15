package com.colodin.mvvmviewcustom.product

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.colodin.mvvmviewcustom.product.data.HProduct
import com.colodin.mvvmviewcustom.product.data.HProductImpl
import com.colodin.mvvmviewcustom.product.domain.ProductProcessor
import com.colodin.mvvmviewcustom.product.domain.ProductProcessorImpl
import com.colodin.mvvmviewcustom.product.presentation.ProductViewModel
import org.koin.dsl.module

val ProductModule = module {

    single<HProduct> { HProductImpl() }
    single<ProductProcessor> { ProductProcessorImpl() }

    factory { (owner: ViewModelStoreOwner) ->
        ViewModelProvider(owner, ProductViewModel.Factory())[ProductViewModel::class.java]
    }
}