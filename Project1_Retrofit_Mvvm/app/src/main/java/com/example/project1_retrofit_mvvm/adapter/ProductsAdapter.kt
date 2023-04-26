package com.example.product_retrofit_mvvm.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.product_retrofit_mvvm.network.model.ProductsModelItem
import com.example.project1_retrofit_mvvm.R

class ProductsAdapter(private val products: List<ProductsModelItem>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]


        holder.bind(product)



    }

    override fun getItemCount(): Int = products.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.productName)
        private val priceTextView: TextView = itemView.findViewById(R.id.productPrice)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: ProductsModelItem) {
            titleTextView.text = product.title
            priceTextView.text = product.price.toString()
            //GlideToVectorYou.justLoadImage(activity, Uri.parse(product.image),productImageView)
            //Glide.with(itemView.context.load(product.image).into(productImageView)

            //Glide.with(itemView.context).load(product.image).into(productImageView).with(itemView.context).load(photo.imageUrl).into(imageView)
        }
    }
}
