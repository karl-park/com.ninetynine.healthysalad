import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Base
import com.example.healthysalad.*
import com.example.domain.Order

class ViewAdapter(private val myDataset: MutableList<Base>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_item_view, parent, false)
        Log.d("LOG" , "viewholder created ")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val item = myDataset[position]
        val res = holder.itemView.context.resources
        holder.itemButton.text = item.name
        holder.itemButton.setOnClickListener{
        Toast.makeText(it.context,"${item.name} added", Toast.LENGTH_SHORT).show()
            val order = Order
            order.addItem(item)
            Log.d("Item Ordered" , "Ordered : ${order.getOrder()}")
            Log.d("Item Select" , "${item.name} selected")
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    fun updateMyDataset(list: List<Base>) {
        Log.d("LOG" , "Update myDataset list: ${list.toString()}")
        myDataset.addAll(list)
        notifyDataSetChanged()
        Log.d("LOG" , "myDataSet : ${myDataset.toString()}")
        myDataset.forEach { item -> Log.d("Called in callback:", item.name) }
    }
}