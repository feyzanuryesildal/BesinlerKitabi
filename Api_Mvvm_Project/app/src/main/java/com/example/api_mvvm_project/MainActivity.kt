package com.example.api_mvvm_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.api_mvvm_project.adapter.ProductPagedAdapter
import com.example.api_mvvm_project.databinding.ActivityMainBinding
import com.example.api_mvvm_project.viewmodels.ProductsViewModel

import kotlinx.coroutines.launch
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productPagedAdapter: ProductPagedAdapter
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadData()


    }

    private fun setupRecyclerView() {

        productPagedAdapter = ProductPagedAdapter()

        binding.recyclerView.apply {
            adapter = productPagedAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

    }

    private fun loadData() {

        lifecycleScope.launch {
            viewModel.listData.collect {

                Log.d("aaa", "load: $it")
                productPagedAdapter.submitData(it)
            }

        }
    }
}