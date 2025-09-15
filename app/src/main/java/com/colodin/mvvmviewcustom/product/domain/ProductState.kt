package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import com.colodin.mvvmviewcustom.utilis.OneTimeEvent

data class ProductState(

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultItems]
     */
    val productItems: OneTimeEvent<List<QAProductShort>>? = null,

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultProductShowProgress]
     */
    val productShowProgress: OneTimeEvent<Boolean>? = null,

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultProductErrorMessage]
     */
    val productErrorMessage: OneTimeEvent<String>? = null,


    /**
     *
     * [ProductProcessor.onProductActionFullProduct]
     * [ProductResult.ProductResultFullProduct]
     */
    val fullProduct: OneTimeEvent<QAProductFull>? = null,


    )