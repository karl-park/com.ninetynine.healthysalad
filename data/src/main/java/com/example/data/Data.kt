package com.example.data

import android.util.Log
import com.example.domain.Base
import com.example.domain.Item
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class Data {
    // to put data into classes
    lateinit var items: List<FoodType>



    //var base: Call<List<Item>> = service.listItems("base")
    var ingredients  = listOf<String>("base.json", "crunchy.json", "dressing.json","protein.json","soft.json")

    fun loadData (){
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        var service: DataGetter = retrofit.create(DataGetter::class.java)

        for (item in ingredients) {
            var call: Call<Item> = service.listItems(item)

            call.enqueue(object: Callback<Item>{
                override fun onFailure(call: Call<Item>, t: Throwable) {
                    Log.d("LOG", t.toString())
                }
                override fun onResponse(call: Call<Item>, response: Response<Item>) {

                    //Log.d("Printing Item", response.body()?.body?.data?.base?.forEach (base.name))
                    response.body()?.body?.data?.base?.forEach{item -> Log.d( "LOG", item.name)}

                }

            })
            // print item
            // Log.d("TAG",item.name)
            // TODO : convert item to object
            // TODO: add to list
        }
    }
}