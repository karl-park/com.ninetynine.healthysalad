package com.example.healthysalad

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val textView: TextView): RecyclerView.ViewHolder(textView) {
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //val itemName : TextView = itemView.findViewById(R.id.itemName)
    val itemButton : Button = itemView.findViewById(R.id.itemButton)
    var itemPosition : Int = 0
}