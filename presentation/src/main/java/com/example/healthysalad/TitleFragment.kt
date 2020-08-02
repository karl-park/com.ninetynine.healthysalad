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

        val createSalad = SelectIngredientFragment.newInstance("base")

        val openChooseFrag: Button = v.findViewById(R.id.create_salad)
        openChooseFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, createSalad)
                .addToBackStack(null).commit()
        }
        return v
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Title_Fragment.
         */
        @JvmStatic
        fun newInstance() =
            TitleFragment().apply {}
    }
}