package com.example.healthysalad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View = inflater.inflate(R.layout.fragment_title,container, false)
        val openChooseFrag: Button = v.findViewById(R.id.create_salad)
        openChooseFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectProteinFragment())
                .addToBackStack(null).commit()
        }
        return v
    }
}