package com.example.product_retrofit_mvvm.network

import com.example.product_retrofit_mvvm.network.model.ProductsModel
import com.example.product_retrofit_mvvm.network.model.ProductsModelItem
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getDataFromApi(): Call<ProductsModel>

}