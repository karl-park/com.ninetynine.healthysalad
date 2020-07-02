package com.example.data

import android.util.Log
import com.example.domain.Base
import com.example.domain.Item
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
class Data {
    var repo : MutableMap < String, List<Base>> = mutableMapOf()

    private fun loadData (item : String) {
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
                    onLoadSuccess(response, item)
                }
            })
    }

    private fun loadItem(item : String){
        val fileName = "$item.json"
        loadData(fileName)
    }

    fun loadAllItems(){
        var ingredients  = listOf<String>("base", "crunchy", "dressing","protein","soft")
        for (item in ingredients){
            loadItem(item)
        }
    }

    fun onLoadSuccess(response : Response<Item>, item: String){
       var data :List<Base> = response.body()?.body?.data?.base?: emptyList()
        repo[item] = data
        data.forEach { item -> Log.d("Added to repo", item.name )}
        //repo.forEach { v -> Log.d("In Repo", "$v" )}
    }
}
