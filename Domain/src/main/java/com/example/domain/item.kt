package com.example.domain

data class Item (
    val name: String,
    val price: Float,
    val currency: String
    ) {

    fun priceString(price: Float ) : String {
        return price.toString()
    }
}