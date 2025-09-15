package com.colodin.mvvmviewcustom.product.presentation

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.colodin.mvvmviewcustom.TestApplication
import com.colodin.mvvmviewcustom.product.ProductModule
import com.colodin.mvvmviewcustom.product.data.QAProductFull
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext
import com.colodin.mvvmviewcustom.R

class TestProductFullFragment: KoinComponent {

    private val templateFullProduct by lazy {
        QAProductFull(id = 1, title = "title", description = "description", price = "$1.00", discountPercentage = "1.00%", rating = 5.00f, stock = "10", category = "category", images = emptyList())

    }

    @Before
    fun setUp() {
        GlobalContext.startKoin {
            androidContext(ApplicationProvider.getApplicationContext<TestApplication>())
            modules(
                ProductModule,
            )
        }
    }

    @After
    fun tearDown() {
        GlobalContext.stopKoin()
    }


    @Test
    fun testFullFragment() {

        val scenario = launchFragmentInContainer<ProductFullFragment>()
        var baseViewModel: ProductViewModel? = null
        scenario.onFragment { fragment ->
            baseViewModel = ViewModelProvider(fragment.requireActivity(), ProductViewModel.Factory())[ProductViewModel::class.java]
        }

        baseViewModel?.fullProduct(templateFullProduct)

        Espresso.onView(ViewMatchers.withId(R.id.productFullTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productFullTitle)).check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("title"))))

        Espresso.onView(ViewMatchers.withId(R.id.productFullPrice)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productFullPrice)).check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$1.00"))))

        Espresso.onView(ViewMatchers.withId(R.id.productFullCategory)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productFullCategory)).check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("category"))))

        Espresso.onView(ViewMatchers.withId(R.id.productFullDiscount)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productFullDiscount)).check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("1.00%"))))

        Espresso.onView(ViewMatchers.withId(R.id.productFullStock)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productFullStock)).check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("10"))))

        scenario.close()
    }
}