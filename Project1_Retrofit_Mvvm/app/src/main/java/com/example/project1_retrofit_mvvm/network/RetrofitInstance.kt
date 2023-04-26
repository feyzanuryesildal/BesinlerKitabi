package com.example.product_retrofit_mvvm.network

import com.example.product_retrofit_mvvm.network.model.BASE_URL
import com.example.product_retrofit_mvvm.network.model.ProductsModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}
