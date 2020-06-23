package com.example.data

import com.example.domain.Base
import com.example.domain.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataGetter {
    @GET("api/{item}")
    fun listItems(@Path("item") item: String): Call<Item>
}