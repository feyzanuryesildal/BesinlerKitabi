package com.example.mvvm_with_retrofit.productList

import com.example.mvvm_with_retrofit.network.response.ProductList
import retrofit2.Call

interface ProductListRepository {
    fun getProducts() : Call<ProductList>
}