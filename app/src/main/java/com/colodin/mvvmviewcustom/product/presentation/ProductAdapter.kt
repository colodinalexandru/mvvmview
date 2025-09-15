package com.colodin.mvvmviewcustom.product.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.colodin.mvvmviewcustom.databinding.ItemProductShortBinding
import com.colodin.mvvmviewcustom.product.data.QAProductShort
import com.colodin.mvvmviewcustom.utilis.RoundCornersTransform
import com.squareup.picasso.Picasso

class ProductAdapter(private val onClick: (QAProductShort) -> Unit) : ListAdapter<QAProductShort, ProductAdapter.ItemProductShortHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductShortHolder {
        return ItemProductShortHolder(ItemProductShortBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClick)
    }

    override fun onBindViewHolder(holder: ItemProductShortHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemProductShortHolder(private val binding: ItemProductShortBinding, private val onClick: (QAProductShort) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QAProductShort) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            Picasso.get().load(item.thumbnail).transform(RoundCornersTransform(32.0f)).into(binding.productThumbnail)
            binding.productShortTitle.text = item.title
            binding.productShortPrice.text = item.price
            binding.productShortRating.rating = item.rating
        }
    }

}


private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QAProductShort>() {
    override fun areItemsTheSame(oldItem: QAProductShort, newItem: QAProductShort): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: QAProductShort, newItem: QAProductShort): Boolean {
        return oldItem == newItem
    }
}