package com.example.svastirinterview.retrofit

import com.example.svastirinterview.models.Item
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiHolder {


    @GET("photos")
    fun getItems(): Call<ArrayList<Item>>
}