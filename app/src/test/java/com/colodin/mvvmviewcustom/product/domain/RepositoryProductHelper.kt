package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.services.data.SProductFull
import com.colodin.mvvmviewcustom.services.data.SProductShort

interface RepositoryProductHelper {

    var productShorts:  List<SProductShort>?

    var productFull: SProductFull?
}