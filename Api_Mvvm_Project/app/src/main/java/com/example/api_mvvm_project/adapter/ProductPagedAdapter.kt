package com.example.api_mvvm_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_mvvm_project.databinding.ProductLayoutBinding
import com.example.api_mvvm_project.models.ProductsModelItem

class ProductPagedAdapter:PagingDataAdapter<ProductsModelItem, ProductPagedAdapter.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(
        val binding: ProductLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ProductsModelItem>() {
            override fun areItemsTheSame(oldItem: ProductsModelItem, newItem: ProductsModelItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductsModelItem, newItem: ProductsModelItem): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ProductLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                //tvDescription.text = "${currChar?.name}"

                val imageLink = currChar?.image
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }

}