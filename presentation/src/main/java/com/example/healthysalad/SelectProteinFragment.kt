package com.example.healthysalad

import MyAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Data

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectProteinFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectProteinFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v : View = inflater.inflate(R.layout.fragment_select_protein,container, false)
        val recyclerView : RecyclerView = v.findViewById(R.id.protein_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        val data = Data()
        val item = "protein"
        val repoData = data.repoWithKey(item)
        val viewAdapter = MyAdapter(repoData)
        recyclerView.adapter = viewAdapter
        //data.loadItem(item, callback)
        data.loadItem(item) { abc ->
            viewAdapter.updateMyDataset(repoData)
        }


        val openBackFrag: Button = v.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectBaseFragment())
                .addToBackStack(null).commit()
        }

        val openNextFrag: Button = v.findViewById(R.id.next_button)
        openNextFrag.setOnClickListener{
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, SelectCrunchyFragment())
                .addToBackStack(null).commit()
        }
        return v
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