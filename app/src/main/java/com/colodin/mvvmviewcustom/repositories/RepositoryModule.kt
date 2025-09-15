package com.colodin.mvvmviewcustom.repositories

import com.colodin.mvvmviewcustom.repositories.impls.DummyServiceProductImpl
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProduct
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProductImpl
import com.colodin.mvvmviewcustom.services.ServiceProduct
import org.koin.dsl.module

val RepositoryModule = module {

    single<ServiceProduct> { DummyServiceProductImpl() }

    single<RepositoryProduct> { RepositoryProductImpl() }
}