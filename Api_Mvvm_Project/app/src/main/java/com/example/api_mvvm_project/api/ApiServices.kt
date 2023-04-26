package com.example.api_mvvm_project.api
import com.example.api_mvvm_project.models.ProductsModelItem
import com.example.api_mvvm_project.utils.Constants
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page")page:Int

    ):Response<ProductsModelItem> //model data class

}