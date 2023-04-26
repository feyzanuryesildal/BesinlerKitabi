package com.example.api_mvvm_project.models

data class ProductsModelItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String,
    //val results: List<ProductsModelItem>

) {

}