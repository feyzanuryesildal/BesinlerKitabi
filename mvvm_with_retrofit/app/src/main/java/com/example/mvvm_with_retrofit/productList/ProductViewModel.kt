package com.example.mvvm_with_retrofit.productList


import android.util.Log
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_with_retrofit.network.ProductApi.productService
import com.example.mvvm_with_retrofit.network.State
import com.example.mvvm_with_retrofit.network.response.ProductList
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    private val productList = MutableLiveData<ProductList>()
    val productListData: LiveData<ProductList> get() = productList

    private val state = MutableLiveData<RecyclerView.State>()
    val stateData: LiveData<RecyclerView.State> get() = state

    val TAG = ProductViewModel::class.simpleName

    private lateinit var repository: ProductListImpl

    /*init {
        getProducts()
    }*/

    //200 - Success
    //300 - Redirection
    //400 - Error
    //500 - Server Error

    fun setRepo(repositoryImpl: ProductListImpl) {
        repository = repositoryImpl
    }


    fun getProducts() {
        state.value = State.LOADING
        viewModelScope.launch {
            repository.getProducts().enqueue(object : Callback<ProductList> {
                override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                    if (response.isSuccessful) {
                        response.body()?.let { productListResponse ->
                            Log.d(TAG, "ServiceSuccess")
                            state.value = State.COMPLETED
                            productList.postValue(productListResponse)
                        }?: kotlin.run {
                            state.value = State.ERROR
                            Log.d(TAG, "EmptyBody")
                        }

                    } else {
                        state.value = State.ERROR
                        Log.d(TAG, "ServiceFailed ${response.message()}")

                    }
                }

                override fun onFailure(call: Call<ProductList>, t: Throwable) {
                    state.value = State.ERROR
                    Log.d(TAG, "ServiceFailed ${t.message}")
                }
            } )


        }
    }
}