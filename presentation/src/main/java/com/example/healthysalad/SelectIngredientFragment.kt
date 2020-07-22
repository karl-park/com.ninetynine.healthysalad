package com.example.healthysalad

import ViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Data


/**
 * A simple [Fragment] subclass.
 * Use the [SelectIngredientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectIngredientFragment (ingredientType : String) : Fragment() {
    private val ingredientType = ingredientType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_select_protein,container, false)
        val data = Data() // make singleton class also
        val repoData = data.repoWithKey(this.ingredientType)
        val viewManager: RecyclerView.LayoutManager = GridLayoutManager(view.context, 2)
        val viewAdapter: ViewAdapter = ViewAdapter(repoData)
        //val itemName : String = ingredientType + "_recycler_view"
        //val viewId : Int = R.id.{itemName}
        val recyclerView : RecyclerView = view.findViewById(R.id.)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter


        data.loadItem(this.ingredientType) { dataResponse ->
            viewAdapter.updateMyDataset(dataResponse)
            Log.d("repoData Callback:" , repoData.toString())
        }

        val openBackFrag: Button = view.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectBaseFragment())
                .addToBackStack(null).commit()
        }

        val openNextFrag: Button = view.findViewById(R.id.next_button)
        openNextFrag.setOnClickListener{
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectCrunchyFragment())
                .addToBackStack(null).commit()
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @param param1 Parameter 1.
         * @return A new instance of fragment SelectProteinFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectProteinFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
