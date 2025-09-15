package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.HProduct
import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProduct
import com.colodin.mvvmviewcustom.utilis.toCurrencyString
import com.colodin.mvvmviewcustom.utilis.toStringWithLocal
import com.colodin.mvvmviewcustom.utilis.toStringWithPercent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber
import java.math.BigDecimal
import java.util.Locale

class ProductProcessorImpl : ProductProcessor, KoinComponent {

    private val repositoryProduct: RepositoryProduct by inject()
    private val hProduct: HProduct by inject()

    override suspend fun onProductActionInit(productResult: ProductResult) {

        productResult.productShowProgress(true)

        try {
            val products = repositoryProduct.getProducts()
            if (products.isEmpty()) {
                productResult.productErrorMessage("No products in stock")
                return
            }

            // no info about the currency or rate change
            val productItems = products.map { QAProductShort(id = it.id, title = it.title, price = it.price.toCurrencyString(Locale.US), rating = it.rating.toFloat(), thumbnail = it.thumbnail) }
            productResult.productResultItems(productItems)

        } catch (e: Exception) {
            productResult.productErrorMessage("Something wrong try again later")
            Timber.e(e)
        } finally {
            productResult.productShowProgress(false)
        }
    }

    override suspend fun onProductActionFullProduct(productId: Int, productResult: ProductResult) {

        Timber.d("-----onProductActionFullProduct-> productID", productId)
        productResult.productShowProgress(true)
        try {
            val product = repositoryProduct.getProduct(productId)
            val productFull = QAProductFull(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price.toCurrencyString(Locale.US),
                discountPercentage = product.discountPercentage.toStringWithPercent(Locale.US),
                rating = product.rating.toFloat(),
                stock = BigDecimal(product.stock).toStringWithLocal(Locale.US),
                category = product.category,
                images = hProduct.getImagesWithoutThumbnail(product.images)
            )

            productResult.fullProduct(productFull)
        } catch (e: Exception) {
            productResult.productErrorMessage("Something wrong try again later")
            Timber.e(e)
        } finally {
            productResult.productShowProgress(false)
        }
    }
}