package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort

interface TestResultGet {

    fun productItems(): List<QAProductShort>

    fun fullProduct(): List<QAProductFull>

    fun showProgress(): List<Boolean>

    fun showErrorMessages(): List<String>
}