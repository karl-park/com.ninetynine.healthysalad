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
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Data
import kotlinx.android.synthetic.main.fragment_select_ingredient.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [SelectIngredientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val INGREDIENTTYPE  = "base"

class SelectIngredientFragment () : Fragment() {

    private var type: String = "base"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString(INGREDIENTTYPE).toString()
            Log.d("tag", type)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_select_ingredient,container, false)
        Log.d("tag", type)

        //view.select_ingredient.text = "Select " + INGREDIENTTYPE.capitalize()
        view.select_ingredient.text = "Select " + type.capitalize()

        val data = Data() // make singleton class also
        val repoData = data.repoWithKey(type)
        val viewManager: RecyclerView.LayoutManager = GridLayoutManager(view.context, 2)
        val viewAdapter: ViewAdapter = ViewAdapter(repoData)
        val recyclerView : RecyclerView = view.findViewById(R.id.ingredient_recycler_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        data.loadItem(type) { dataResponse ->
            viewAdapter.updateMyDataset(dataResponse)
            Log.d("repoData Callback:" , repoData.toString())
        }


        //Log.d("Prev Frag ", FragmentScheduler(INGREDIENTTYPE).getPrevState())
        Log.d("Next Frag ", FragmentScheduler(type).getNextState())

        val openBackFrag: Button = view.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, newInstance(FragmentScheduler(
                    type).getPrevState())
                )
                .addToBackStack(null).commit()
            Log.d("Prev Frag ", FragmentScheduler(type).getPrevState())
        }

        val openNextFrag: Button = view.findViewById(R.id.next_button)
        openNextFrag.setOnClickListener{
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, newInstance(FragmentScheduler(
                    type).getNextState()))
                .addToBackStack(null).commit()
            //Log.d("Next Frag ", FragmentScheduler(INGREDIENTTYPE).getNextState())

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

        /*fun newInstance(foo: String): SelectIngredientFragment {
            val args = Bundle()
            args.putString("foo", foo)
            val fragment = SelectIngredientFragment()
            fragment.arguments = args
            return fragment
        }*/

        //lateinit var INGREDIENTTYPE : String
        //var INGREDIENTTYPE = "base"
/*
        fun newInstance(ingredientType : String) = SelectIngredientFragment().apply {
            arguments = bundleOf(
                INGREDIENTTYPE to ingredientType)
        }
*/
        @JvmStatic
        fun newInstance(ingredientType : String) =
            SelectIngredientFragment().apply {
                arguments = Bundle().apply {
                    putString(INGREDIENTTYPE, ingredientType)
                }
            }
    }
}
