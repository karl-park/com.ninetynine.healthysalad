package com.example.healthysalad


class FragmentScheduler(currentState : String){
    //var nextState : String = "Base"
    //var prevState : String = "Base"
    val fragmentFlow : List<String> = listOf("base", "protein","crunchy")

    fun getNextState(currentState: String) : String {
        val pos = fragmentFlow.indexOf(currentState)

        return fragmentFlow[pos + 1]
    }

    fun getPrevState (currentState: String)  : String{
        val pos = fragmentFlow.indexOf(currentState)
        return fragmentFlow[pos - 1]
    }
}

//TODO take care of range bounds