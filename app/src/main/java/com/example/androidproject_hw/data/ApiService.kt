package com.example.androidproject_hw.data

import com.example.androidproject_hw.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getData():Response<List<ItemsResponse>>

}