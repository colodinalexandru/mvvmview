package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort

class TestProductResultImpl : TestResultGet, ProductResult {

    private var lProductItems: List<QAProductShort> = emptyList()
    private var lProductShowProgress = mutableListOf<Boolean>()
    private var lFullProduct = mutableListOf<QAProductFull>()
    private var lProductErrorMessage = mutableListOf<String>()

    override fun productResultItems(items: List<QAProductShort>) {
        lProductItems = items
    }

    override fun productShowProgress(showProgress: Boolean) {
        lProductShowProgress.add(showProgress)
    }

    override fun productErrorMessage(errorMessage: String) {
        lProductErrorMessage.add(errorMessage)
    }

    override fun fullProduct(productFull: QAProductFull) {
        lFullProduct.add(productFull)
    }


    override fun productItems(): List<QAProductShort> {
        return lProductItems
    }

    override fun fullProduct(): List<QAProductFull> {
        return lFullProduct
    }

    override fun showProgress(): List<Boolean> {
        return lProductShowProgress
    }

    override fun showErrorMessages(): List<String> {
        return lProductErrorMessage
    }


}