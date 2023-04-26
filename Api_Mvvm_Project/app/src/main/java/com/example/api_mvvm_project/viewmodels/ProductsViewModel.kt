package com.example.api_mvvm_project.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.api_mvvm_project.api.ApiServices
import com.example.api_mvvm_project.paging.ProductsPagingSource
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
/*
@HiltAndroidApp
class ProductsViewModel
    @Inject
    constructor(
        private val apiService: ApiServices
    ) : ViewModel() {

        val listData = Pager(PagingConfig(pageSize = 1)) {
            ProductsPagingSource(apiService)

        }.flow.cachedIn(viewModelScope)

    }*/


@HiltViewModel
class ProductsViewModel
@Inject
constructor(
    private val apiService: ApiServices
) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        ProductsPagingSource(apiService)

    }.flow.cachedIn(viewModelScope)

}
