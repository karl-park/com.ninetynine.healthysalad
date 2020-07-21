import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Base
import com.example.healthysalad.*
import com.example.domain.Order

class ViewAdapter(private val myDataset: MutableList<Base>, context: Context?) :
    RecyclerView.Adapter<ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    // class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    var data = listOf<Base>()
    set (value){
        field = value
        notifyDataSetChanged()
    }
    val context = context
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false)
        // set the view's size, margins, paddings and layout parameters
        //holder.textView.text = myDataset.get(position).name
        Log.d("callback called" , "view holder created ")
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val item = myDataset[position]
        val res = holder.itemView.context.resources
        //holder.itemName.text = item.name
        holder.itemButton.text = item.name
        holder.itemPosition = position
/*        val button : Button = holder.itemButton
        button.setOnClickListener {
            Log.d("Button" , "Pressed $item")
        }
*/
        holder.itemButton.setOnClickListener{
            Toast.makeText(context,"${item.name} added", Toast.LENGTH_SHORT).show()
            Order().addItem(item)
            Log.d("Item Select" , "${item.name} selected")
        }
        //holder.textView.text = myDataset.get(position).name

    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    // Return the size of your dataset (invoked by the layout manager)
    // override fun getItemCount(): Int = myDataset?.size!!
    fun updateMyDataset(list: List<Base>) {
        //myDataset.clear()
        Log.d("update my data set list:" , list.toString())
        myDataset.addAll(list)
        notifyDataSetChanged()
        //notifyItemChanged(0)
        Log.d("callback called" , "called here ")
        Log.d("mydataset" , myDataset.toString())
        myDataset.forEach { item -> Log.d("Called in callback:", item.name) }
    }

    interface ViewAdapterCallback {
        fun onItemClicked(base: Base)
    }
}