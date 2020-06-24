package com.example.data

import android.util.Log
import com.example.domain.Base
import com.example.domain.FoodType
import com.example.domain.Item
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
class Data {
    // to put data into classes
    var repo: MutableList<FoodType> = mutableListOf()
    //var base: Call<List<Item>> = service.listItems("base")
    var ingredients  = listOf<String>("base.json", "crunchy.json", "dressing.json","protein.json","soft.json")
    private fun loadData (item : String): List<Base> {
        var data : List<Base> = emptyList()
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        var service: DataGetter = retrofit.create(DataGetter::class.java)
        var call: Call<Item> = service.listItems(item)
            call.enqueue(object: Callback<Item> {
                override fun onFailure(call: Call<Item>, t: Throwable) {
                    Log.d("Called", t.toString())
                }
                override fun onResponse(call: Call<Item>, response: Response<Item>) {
                    response.body()?.body?.data?.base?.forEach{item -> Log.d( "Called", item.name)}
                    data = response.body()?.body?.data?.base?: emptyList()
                }
            })
        return data
    }

    private fun loadItem(item : String){
        val fileName = "$item.json"
        var list = loadData(fileName)
        var foodType = FoodType(list)
        repo.add(foodType)
        list.forEach { item -> Log.d("Added to list", item.name )}
    }

    fun loadAllItems(){
        var ingredients  = listOf<String>("base", "crunchy", "dressing","protein","soft")
        for (item in ingredients){
            loadItem(item)
        }
    }
}