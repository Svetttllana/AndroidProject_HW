package com.example.clswrk_androidprojekt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.clswrk_androidprojekt.databinding.ItemsCatsBinding
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsAdapter(private var itemsListener: ItemsListener) :
    RecyclerView.Adapter<ItemsViewHolder>() {


    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>) {
        listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

        val viewBinding = ItemsCatsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ItemsViewHolder(viewBinding, itemsListener)
    }


    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}