package com.example.data

import retrofit2.Call
import retrofit2.http.GET




interface ItemGetter {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): C all<List<Repo?>?>?
}