package com.colodin.mvvmviewcustom.product.domain

interface ProductProcessor {

    /**
     *
     * [ProductProcessorImpl.onProductActionInit]
     */
    suspend fun onProductActionInit(productResult: ProductResult)

    /**
     *
     * [ProductProcessorImpl.onProductActionFullProduct]
     */
    suspend fun onProductActionFullProduct(productId: Int, productResult: ProductResult)
}