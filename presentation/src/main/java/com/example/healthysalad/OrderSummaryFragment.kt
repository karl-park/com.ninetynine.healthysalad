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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Order

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderSummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderSummaryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_order_summary, container,false)
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(view.context)
        val viewAdapter: OrderSummaryViewAdapter = OrderSummaryViewAdapter(Order)
        val recyclerView : RecyclerView = view.findViewById(R.id.order_summary_recycler_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter


        val openBackFrag: Button = view.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
                activity!!.supportFragmentManager
                    .beginTransaction().replace(
                        R.id.activity_main, SelectIngredientFragment.newInstance("soft") // TODO: make select ingredient fragment scheduler be able to be accessed
                    )
                    .addToBackStack(null).commit()
            }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderSummaryFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderSummaryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}