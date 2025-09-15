package com.colodin.mvvmviewcustom.repositories.product

import com.colodin.mvvmviewcustom.services.data.SProductFull
import com.colodin.mvvmviewcustom.services.data.SProductShort

interface RepositoryProduct {

    /**
     *
     * [RepositoryProductImpl.getProducts]
     *
     */
    suspend fun getProducts(): List<SProductShort>

    /**
     *
     * [RepositoryProductImpl.getProduct]
     */
    suspend fun getProduct(id: Int): SProductFull
}