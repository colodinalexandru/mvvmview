package com.colodin.mvvmviewcustom.product.presentation

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import com.colodin.mvvmviewcustom.TestApplication
import com.colodin.mvvmviewcustom.product.ProductModule
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext
import com.colodin.mvvmviewcustom.R
import org.hamcrest.Description
import org.hamcrest.Matcher

class TestProductFragment : KoinComponent {

    private val templateProductShort by lazy {
        QAProductShort(id = 1, title = "title", price = "$1.00", rating = 4f, thumbnail = "https://test.com")
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
    fun startFragment() {

        val scenario = launchFragmentInContainer<ProductFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.productShortRecycler)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )

        scenario.close()
    }


    @Test
    fun checkVisibleItems() {


        val scenario = launchFragmentInContainer<ProductFragment>()
        var baseViewModel: ProductViewModel? = null
        scenario.onFragment { fragment ->
            baseViewModel = ViewModelProvider(fragment.requireActivity(), ProductViewModel.Factory())[ProductViewModel::class.java]
        }

        baseViewModel?.productResultItems(listOf(templateProductShort,templateProductShort.copy(title = "title2", price = "price2", rating = 5f)))

        Espresso.onView(ViewMatchers.withId(R.id.productShortRecycler)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )

        Espresso.onView(ViewMatchers.withId(R.id.productShortRecycler)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.productShortRecycler)).check(ViewAssertions.matches(withViewAtPosition(0,templateProductShort)))
        Espresso.onView(ViewMatchers.withId(R.id.productShortRecycler)).check(ViewAssertions.matches(withViewAtPosition(1,templateProductShort.copy(title = "title2", price = "price2", rating = 5.0f))))


        scenario.close()
    }

}

private fun withViewAtPosition(
    position: Int,
    item: QAProductShort
): Matcher<View?> {
    return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {

        }

        override fun matchesSafely(recyclerView: RecyclerView): Boolean {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
            val itemView = (viewHolder as ProductAdapter.ItemProductShortHolder).itemView
            val productShortPrice = itemView.findViewById<TextView>(R.id.productShortPrice)
            val productShortTitle = itemView.findViewById<TextView>(R.id.productShortTitle)
            val productShortRating = itemView.findViewById<RatingBar>(R.id.productShortRating)
            return productShortPrice.text == item.price && productShortTitle.text == item.title && productShortRating.rating == item.rating
        }
    }
}