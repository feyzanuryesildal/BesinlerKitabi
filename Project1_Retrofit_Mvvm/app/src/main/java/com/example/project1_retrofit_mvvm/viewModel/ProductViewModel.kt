package com.example.product_retrofit_mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.product_retrofit_mvvm.network.RetrofitInstance
import com.example.product_retrofit_mvvm.network.ProductService
import com.example.product_retrofit_mvvm.network.model.ProductsModel
import com.example.product_retrofit_mvvm.network.model.ProductsModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel(){
    //var ProductDataList = MutableLiveData<List<ProductsModel>>()
    /*val productList: MutableLiveData<List<ProductsModel>> by lazy {
        MutableLiveData<List<ProductsModel>>()
    }*/
    private val productList = MutableLiveData<ProductsModel> ()
    val productListData: LiveData<ProductsModel> get() = productList
    fun getApiData(){

        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ProductService::class.java)
        retrofitInstance.getDataFromApi().enqueue(object : Callback<ProductsModel> {
            override fun onResponse(
                call: Call<ProductsModel>,
                response: Response<ProductsModel>
            ) {
                productList.postValue(response.body())
            }

            override fun onFailure(call: Call<ProductsModel>, t: Throwable) {

            }

        })

    }
}