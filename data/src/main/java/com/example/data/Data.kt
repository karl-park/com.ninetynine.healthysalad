package com.example.data

import android.util.Log
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
            var call: Call<List<Item>> = service.listItems(item)


            call.enqueue(object: Callback<List<Item>>{
                override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                    //TODO("Not yet implemented")
                    response.body()?.forEach{item -> Log.d("Printing Item", item.name)}
                }
            })
                // print item
            //Log.d("TAG",item.name)


            // TODO : convert item to object
            // TODO: add to list



        }
    }
}