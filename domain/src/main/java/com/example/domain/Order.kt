package com.example.domain

class Order (

    /*map
    (base : Base, CC, crunchy:Base, protein:Base)*/
)
{
    val order : MutableList<Base> = mutableListOf()

    fun addItem(base : Base) {
        order.add(base)
    }

    /*
  fun getOrder(): MutableList<Base> {
        return this.order
    }
*/
}
