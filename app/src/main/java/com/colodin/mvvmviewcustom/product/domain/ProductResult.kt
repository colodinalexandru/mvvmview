package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort

interface ProductResult {

    fun productResultItems(items:List<QAProductShort>)

    fun productShowProgress(showProgress:Boolean)

    fun productErrorMessage(errorMessage:String)

    fun fullProduct(productFull: QAProductFull)
}