package com.example.healthysalad

import ViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Data
import kotlinx.android.synthetic.main.fragment_select_ingredient.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [SelectIngredientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SelectIngredientFragment () : Fragment() {
    //private lateinit var INGREDIENTTYPE :String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_select_ingredient,container, false)

        view.select_ingredient.text = "Select " + INGREDIENTTYPE.capitalize()

        val data = Data() // make singleton class also
        val repoData = data.repoWithKey(INGREDIENTTYPE)
        val viewManager: RecyclerView.LayoutManager = GridLayoutManager(view.context, 2)
        val viewAdapter: ViewAdapter = ViewAdapter(repoData)
        val recyclerView : RecyclerView = view.findViewById(R.id.ingredient_recycler_view)



        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        data.loadItem(INGREDIENTTYPE) { dataResponse ->
            viewAdapter.updateMyDataset(dataResponse)
            Log.d("repoData Callback:" , repoData.toString())
        }



        val openBackFrag: Button = view.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectIngredientFragment.newInstance(FragmentScheduler(
                    INGREDIENTTYPE).getPrevState()))
                .addToBackStack(null).commit()
        }

        val openNextFrag: Button = view.findViewById(R.id.next_button)
        openNextFrag.setOnClickListener{
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectIngredientFragment.newInstance(FragmentScheduler(
                    INGREDIENTTYPE).getNextState()))
                .addToBackStack(null).commit()
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @param param1 Parameter 1.
         * @return A new instance of fragment SelectIngredientFragment.
         */

        private const val INGREDIENTTYPE = "base"
        fun newInstance(ingredientType : String) =
            SelectIngredientFragment().apply {
                arguments = Bundle(1).apply {
                    putString(INGREDIENTTYPE, ingredientType)
                }
            }
    }
}
