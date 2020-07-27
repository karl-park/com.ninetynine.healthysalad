package com.example.healthysalad


class FragmentScheduler(currentState : String){
    //var nextState : String = "Base"
    //var prevState : String = "Base"
    val currentState = currentState
    val fragmentFlow : List<String> = listOf("base", "protein","crunchy", "dressing","soft")

    fun getNextState() : String {
        val pos = fragmentFlow.indexOf(currentState)
        var next : String = fragmentFlow.last()
        if (pos < fragmentFlow.size){
            next = fragmentFlow[pos+1]
        }

        return next
    }

    fun getPrevState ()  : String{
        val pos = fragmentFlow.indexOf(currentState)
        var prev : String = fragmentFlow.first()
        if(pos > fragmentFlow.size){
            prev = fragmentFlow[pos-1]
        }
        return prev
    }
}
