package com.colodin.mvvmviewcustom.repositories

import com.colodin.mvvmviewcustom.assay.impls.AssayServiceProductImpl
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProduct
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProductImpl
import com.colodin.mvvmviewcustom.services.ServiceProduct
import org.koin.dsl.module

val RepositoryModule = module {
    single<ServiceProduct> { AssayServiceProductImpl() }
    single<RepositoryProduct> { RepositoryProductImpl() }
}