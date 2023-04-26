package com.example.mvvm_with_retrofit.productList


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.mvvm_with_retrofit.R
import com.example.mvvm_with_retrofit.adapter.ProductAdapter
import com.example.mvvm_with_retrofit.databinding.ActivityMainBinding


import com.example.mvvm_with_retrofit.network.response.ProductList
import com.example.mvvm_with_retrofit.utils.dataBinding
import com.example.mvvm_with_retrofit.utils.hideLoading
import com.example.mvvm_with_retrofit.utils.showLoading
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class ProductActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by dataBinding(R.layout.activity_main)
    var productAdapter: ProductAdapter? = null
    lateinit var rv: RecyclerView

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        sendRequest()
        observeViewModels()


    }

    private fun init() {
        viewModel.setRepo(ProductListImpl())
    }


    private fun sendRequest() {
        viewModel.getProducts()
    }

    private fun observeViewModels() {

        viewModel.productListData.observe(this) {
            adapterLogic(it)
        }

        viewModel.stateData.observe(this) { currentState ->
            when (currentState) {
                State.LOADING -> {
                    Log.d("ServiceStat", "Loading")
                    showLoading()
                }
                State.COMPLETED -> {
                    Log.d("ServiceStat", "Completed")
                    hideLoading()

                }
                State.ERROR -> {
                    Log.d("ServiceStat", "Error")
                    hideLoading()

                }
                null -> {
                    Log.d("ServiceStat", "null")
                }
            }

        }

    }




    /*private fun init(){
        productService.getProduct().enqueue(object : Callback<ProductList>{
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if (response.isSuccessful){
                    Log.d("TAG", "SERVİCE SUCCESS")
                    response.body()?.let {
                        adapterLogic(it)
                    }
                } else {
                    Log.d("TAG","service failed")
                }
            }
            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                Log.d("TAG","service failed ${t.message}")
            }
        })
    }*/

    private fun adapterLogic(productList: ProductList){
        rv = binding.rvProduct
        productAdapter = ProductAdapter(productList,this@ProductActivity)
        rv.adapter= productAdapter
        rv.layoutManager=  LinearLayoutManager(this@ProductActivity)

    }





}