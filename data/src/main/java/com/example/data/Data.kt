package com.example.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create


class Data {
    // to put data into classes
    lateinit var items: List<FoodType>

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/api/")
        .build()

    var service: DataGetter = retrofit.create(DataGetter::class.java)

    var base: Call<List<Item>> = service.listItems("base")
    var ingredients  = listOf<String>("base", "crunchy", "dressing","protein","soft")

    for (item in ingredients)
}