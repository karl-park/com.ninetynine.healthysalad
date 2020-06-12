package com.example.data

import retrofit2.Retrofit
import retrofit2.create


class Data {
    // to put data into classes
    
    var retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()

    var service: DataGetter = retrofit.create()
}