package com.example.clswrk_androidprojekt.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.R
import com.example.androidproject_hw.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel
class ItemsAdapter(private var itemsListener: ItemsListener): RecyclerView.Adapter<ItemsViewHolder>() {





    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>){
        this.listItems=list.toMutableList()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.items_cats,parent,false)
        return ItemsViewHolder(view,itemsListener)
    }


    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}