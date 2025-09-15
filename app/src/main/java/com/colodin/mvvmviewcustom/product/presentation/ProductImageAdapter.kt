package com.colodin.mvvmviewcustom.product.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.colodin.mvvmviewcustom.databinding.ItemProductImageBinding
import com.colodin.mvvmviewcustom.utilis.RoundCornersTransform
import com.squareup.picasso.Picasso

class ProductImageAdapter : ListAdapter<String, ProductImageAdapter.ItemProductImageHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageAdapter.ItemProductImageHolder {
        return ItemProductImageHolder(ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductImageAdapter.ItemProductImageHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemProductImageHolder(private val binding: ItemProductImageBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(thumbnail: String) {
            Picasso.get().load(thumbnail).transform(RoundCornersTransform(32.0f)).into(binding.productThumbnail)
        }
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}