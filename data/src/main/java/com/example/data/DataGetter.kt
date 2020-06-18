package com.example.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataGetter {
    @GET("{item}")
    fun listItems(@Path("item") user: String): Call<List<Item>>
}