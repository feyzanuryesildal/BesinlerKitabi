package com.example.api_mvvm_project.models

data class Rating(
    val count: Int,
    val rate: Double,
    val results: List<ProductsModelItem>
)