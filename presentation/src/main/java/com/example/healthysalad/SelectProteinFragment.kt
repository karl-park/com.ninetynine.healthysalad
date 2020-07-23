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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Data
import java.util.Observer
class SelectProteinFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val item = "protein"
        val v : View = inflater.inflate(R.layout.fragment_select_protein,container, false)
        val data = Data()
        val repoData = data.repoWithKey(item)
        val viewManager: RecyclerView.LayoutManager = GridLayoutManager(v.context, 2)
        val viewAdapter = ViewAdapter(repoData)
        val recyclerView : RecyclerView = v.findViewById(R.id.protein_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        data.loadItem(item) { dataResponse ->
            viewAdapter.updateMyDataset(dataResponse)
            Log.d("repoData Callback:" , repoData.toString())
        }

        val openBackFrag: Button = v.findViewById(R.id.back_button)
        openBackFrag.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, TitleFragment())
                .addToBackStack(null).commit()
        }

        val openNextFrag: Button = v.findViewById(R.id.next_button)
        openNextFrag.setOnClickListener{
            activity!!.supportFragmentManager
                .beginTransaction().replace(R.id.activity_main, TitleFragment())
                .addToBackStack(null).commit()
        }
        return v
    }
}
