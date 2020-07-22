package com.example.healthysalad

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val itemButton : Button = itemView.findViewById(R.id.itemButton)
    var itemPosition : Int = 0
}