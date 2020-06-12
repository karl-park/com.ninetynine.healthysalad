package com.example.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("name", "name")
                .method(original.method(), original.body())
            val request = requestBuilder.build()
        }.build()


    val instance : Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client()

    }
}