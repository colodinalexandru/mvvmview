package com.colodin.mvvmviewcustom.product.domain

import com.colodin.mvvmviewcustom.product.data.HProduct
import com.colodin.mvvmviewcustom.product.data.HProductImpl
import com.colodin.mvvmviewcustom.product.data.QAProductFull
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import com.colodin.mvvmviewcustom.repositories.product.RepositoryProduct
import com.colodin.mvvmviewcustom.services.data.SProductFull
import com.colodin.mvvmviewcustom.services.data.SProductShort
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.GlobalContext
import org.koin.dsl.binds
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import java.math.BigDecimal
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProductProcessorTest : KoinTest {

    private val productResult: ProductResult by inject()

    private val testResultGet: TestResultGet by inject()

    private val testProcessor: ProductProcessor by inject()

    private val helperRepositoryProduct: RepositoryProductHelper by inject()
    private val templateSProductShort by lazy {
        SProductShort(id = 0, title = "title", price = BigDecimal.ONE, rating = BigDecimal.ONE, thumbnail = "")
    }

    private val templateSProductFull by lazy {
        SProductFull(
            id = 0,
            title = "title",
            description = "description",
            price = BigDecimal.ONE,
            discountPercentage = BigDecimal.ONE,
            rating = BigDecimal.ONE,
            stock = 0,
            category = "category",
            thumbnail = "",
            images = emptyList()
        )
    }

    @Before
    fun setUp() {
        GlobalContext.startKoin {
            modules(module {
                single<HProduct> { HProductImpl() }

                single<ProductProcessor> { ProductProcessorImpl() }
                single { TestProductResultImpl() } binds arrayOf(ProductResult::class, TestResultGet::class)
                single { RepositoryProductTestImpl() } binds arrayOf(RepositoryProductHelper::class, RepositoryProduct::class)
            })
        }
    }

    @After
    fun tearDown() {
        GlobalContext.stopKoin()
    }

    @Test
    fun onProductActionInit_error() = runBlocking {
        helperRepositoryProduct.productShorts = null
        testProcessor.onProductActionInit(productResult)

        val showProgress = testResultGet.showProgress()
        assertTrue(showProgress.count() == 2)
        assertTrue(showProgress[0])
        assertFalse(showProgress[1])

        assertTrue(testResultGet.showErrorMessages().count() == 1)
        assertEquals("Something wrong try again later", testResultGet.showErrorMessages()[0])

        assertTrue(testResultGet.productItems().isEmpty())
        assertTrue(testResultGet.fullProduct().isEmpty())
    }

    @Test
    fun onProductActionInit_empty() = runBlocking {
        helperRepositoryProduct.productShorts = emptyList()
        testProcessor.onProductActionInit(productResult)

        val showProgress = testResultGet.showProgress()
        assertTrue(showProgress.count() == 2)
        assertTrue(showProgress[0])
        assertFalse(showProgress[1])

        assertTrue(testResultGet.showErrorMessages().count() == 1)
        assertEquals("No products in stock", testResultGet.showErrorMessages()[0])

        assertTrue(testResultGet.productItems().isEmpty())
        assertTrue(testResultGet.fullProduct().isEmpty())
    }

    @Test
    fun onProductActionInit() = runBlocking {
        helperRepositoryProduct.productShorts = listOf(templateSProductShort, templateSProductShort.copy(id = 1, title = "title 1"))
        testProcessor.onProductActionInit(productResult)

        val showProgress = testResultGet.showProgress()
        assertTrue(showProgress.count() == 2)
        assertTrue(showProgress[0])
        assertFalse(showProgress[1])

        assertTrue(testResultGet.showErrorMessages().isEmpty())
        val productItems = testResultGet.productItems()
        assertTrue(productItems.count() == 2)
        val outputItems = listOf(QAProductShort(id = 0, title = "title", price = "$1.00", rating = 1.00f, thumbnail = ""), QAProductShort(id = 1, title = "title 1", price = "$1.00", rating = 1.00f, thumbnail = ""))
        assertContentEquals(outputItems, productItems)
        assertTrue(testResultGet.fullProduct().isEmpty())
    }

    @Test
    fun onProductActionFullProduct_error() = runBlocking {
        helperRepositoryProduct.productFull = null
        testProcessor.onProductActionFullProduct(1,productResult)


        val showProgress = testResultGet.showProgress()
        assertTrue(showProgress.count() == 2)
        assertTrue(showProgress[0])
        assertFalse(showProgress[1])

        assertTrue(testResultGet.showErrorMessages().count() == 1)
        assertEquals("Something wrong try again later", testResultGet.showErrorMessages()[0])

        assertTrue(testResultGet.productItems().isEmpty())
        assertTrue(testResultGet.fullProduct().isEmpty())

    }

    @Test
    fun onProductActionFullProduct() = runBlocking {
        helperRepositoryProduct.productFull = templateSProductFull
        testProcessor.onProductActionFullProduct(1,productResult)


        val showProgress = testResultGet.showProgress()
        assertTrue(showProgress.count() == 2)
        assertTrue(showProgress[0])
        assertFalse(showProgress[1])

        assertTrue(testResultGet.showErrorMessages().isEmpty())
        assertTrue(testResultGet.productItems().isEmpty())

        assertTrue(testResultGet.fullProduct().count() == 1)
        val fullProduct = testResultGet.fullProduct().first()

        val outPut = QAProductFull(
            id = 0,
            title = "title",
            description = "description",
            price = "$1.00",
            discountPercentage = "1.00%",
            rating = 1.00f,
            stock = "0.00",
            category = "category",
            images = emptyList()
        )

        assertEquals(outPut, fullProduct)

    }
}