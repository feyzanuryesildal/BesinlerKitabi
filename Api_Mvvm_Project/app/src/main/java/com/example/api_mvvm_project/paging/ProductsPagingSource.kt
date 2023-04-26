package com.example.api_mvvm_project.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.api_mvvm_project.api.ApiServices
import com.example.api_mvvm_project.models.ProductsModelItem

class ProductsPagingSource (private val apiServices: ApiServices
): PagingSource<Int, ProductsModelItem>() {
    override fun getRefreshKey(state: PagingState<Int, ProductsModelItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductsModelItem> {
        return try{
            val currentPage = params.key ?: 1
            val response = apiServices.getAllCharacters(currentPage)
            val responseData = mutableListOf<ProductsModelItem>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}