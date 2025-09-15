package com.colodin.mvvmviewcustom.product.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.colodin.mvvmviewcustom.R
import com.colodin.mvvmviewcustom.databinding.FragmentProductBinding
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by inject { parametersOf(requireActivity()) }

    private var _binding: FragmentProductBinding? = null

    private val binding get() = _binding!!

    private val productAdapter by lazy {
        ProductAdapter(::onClickProduct)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onProductActionInit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.productShortRecycler.adapter = productAdapter

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.uiState.collect {
                it.productItems?.consume()?.let { productItems ->
                    productAdapter.submitList(productItems)
                }
            }
        }
    }

    private fun onClickProduct(item: QAProductShort) {
        viewModel.onProductActionFullProduct(item.id)
        Navigation.findNavController(requireActivity(), R.id.nav_host_container).navigate(R.id.navigation_product_full)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}