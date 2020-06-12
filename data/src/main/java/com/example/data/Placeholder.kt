package com.example.data

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface Placeholder {
    @GET("items")
    fun getItems(
        @Query("name") name: String,
        @Query("price") price: String,
        @Query("currency") currency: String
    )

    companion object {
        fun create(): Placeholder {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl("https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/api/")
                .build()

            return retrofit.create(Placeholder::class.java)
        }
    }

    val item by lazy {
        Placeholder.create()
    }

}
