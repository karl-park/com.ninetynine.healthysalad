package com.example.data

import retrofit2.http.GET
import retrofit2.http.Query

interface DataGetter {
    val string: String
    string = " https://raw.githubusercontent.com/karl-park/com.ninetynine.healthysalad/master/server/api/"
    @GET(string)
    fun getData(@Query)



}