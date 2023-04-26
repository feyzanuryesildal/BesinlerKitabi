package com.example.project1_retrofit_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.product_retrofit_mvvm.adapter.ProductsAdapter
import com.example.product_retrofit_mvvm.viewModel.ProductViewModel





class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productsRecyclerView = findViewById<RecyclerView>(R.id.productsRecyclerView)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.getApiData()

        productViewModel.productListData.observe(this){
            productsAdapter = ProductsAdapter(it)
            productsRecyclerView.layoutManager = LinearLayoutManager(this)
            productsRecyclerView.adapter = productsAdapter

        }



    }
}