package com.colodin.mvvmviewcustom.product.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.colodin.mvvmviewcustom.databinding.FragmentProductFullBinding
import com.colodin.mvvmviewcustom.product.data.QAProductFull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf



class ProductFullFragment : Fragment() {

    private val viewModel: ProductViewModel by inject { parametersOf(requireActivity()) }

    private var _binding: FragmentProductFullBinding? = null

    private val binding get() = _binding!!

    private val linearSnapHelper by lazy {
        LinearSnapHelper()
    }
    private val adapterProductImage by lazy {
        ProductImageAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductFullBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productRecyclerFull.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.productRecyclerFull.adapter = adapterProductImage
        linearSnapHelper.attachToRecyclerView(binding.productRecyclerFull)

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.uiState.collect {
                it.fullProduct?.consume()?.let { fullProduct ->
                    onProduct(fullProduct)
                }
            }
        }
    }

    private fun onProduct(item: QAProductFull) {
        adapterProductImage.submitList(item.images)
        binding.productFullTitle.text = item.title
        binding.productFullCategory.text = item.category
        binding.productFullPrice.text = item.price
        binding.productFullStock.text = item.stock
        binding.productFullDiscount.text = item.discountPercentage
        binding.productFullDescription.text = item.description
        binding.productFullRating.rating = item.rating
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}