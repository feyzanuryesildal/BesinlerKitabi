package com.example.mvvm_with_retrofit.network
import com.example.mvvm_with_retrofit.network.response.ProductList
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getProduct(): Call<ProductList>
}