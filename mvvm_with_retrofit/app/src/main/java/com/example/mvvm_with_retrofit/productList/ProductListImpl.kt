package com.example.mvvm_with_retrofit.productList
import com.example.mvvm_with_retrofit.network.ProductApi.productService
import com.example.mvvm_with_retrofit.network.response.ProductList
import retrofit2.Call

class ProductListImpl : ProductListRepository {

    override fun getProducts(): Call<ProductList> {
        return productService.getProduct()
    }

}