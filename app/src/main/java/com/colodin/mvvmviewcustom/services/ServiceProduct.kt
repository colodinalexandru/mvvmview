package com.colodin.mvvmviewcustom.services

import com.colodin.mvvmviewcustom.services.data.SProductFull
import com.colodin.mvvmviewcustom.services.data.SProductShort

/**
 *
 * [com.colodin.mvvmviewcustom.repositories.impls.DummyServiceProductImpl]
 */
interface ServiceProduct {

    /**
     *
     *
     */
    suspend fun getProducts(): List<SProductShort>

    /**
     *
     *
     */
    suspend fun getProduct(id: Int): SProductFull
}