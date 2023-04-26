package com.example.retrofitkriptopara.service

import com.example.retrofitkriptopara.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET
//https://raw.githubusercontent.com/
interface CryptoAPI {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Call<List<CryptoModel>>
}