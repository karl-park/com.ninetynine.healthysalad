package com.example.domain


class Order()
{
    private object Holder {
        val Instance = Order()
    }
    
    companion object{
        val instance : Order by lazy {Holder.Instance}
        private val order : MutableList<Base> = mutableListOf()

        fun addItem(base : Base) {
            this.order.add(base)
        }
        fun getOrder(): MutableList<Base> {
            return this.order
        }

    }
    
    /*map
    (base : Base, CC, crunchy:Base, protein:Base)*/



}
