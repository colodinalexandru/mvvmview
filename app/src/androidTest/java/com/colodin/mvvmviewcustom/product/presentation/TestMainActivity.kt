package com.colodin.mvvmviewcustom.product.presentation

import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.colodin.mvvmviewcustom.product.ProductModule
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext
import com.colodin.mvvmviewcustom.R

class TestMainActivity : KoinComponent {

    @Before
    fun setUp() {
        GlobalContext.startKoin {
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
    fun run_activity_ProductResultShowProgress() {
        val scenario = launchActivity<MainActivity>()
        var baseViewModel: ProductViewModel? = null
        scenario.onActivity {
            baseViewModel = ViewModelProvider(it, ProductViewModel.Factory())[ProductViewModel::class.java]

        }

        baseViewModel?.productShowProgress(true)
        Espresso.onView(withId(R.id.progressBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        baseViewModel?.productShowProgress(false)
        Espresso.onView(withId(R.id.progressBar)).check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
        scenario.close()
    }
}