package com.example.androidproject_hw.Presentation.view.items.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.databinding.ItemsFavoriteBinding

class FavoriteAdapter (): RecyclerView.Adapter<FavoriteViewHolder>() {

    private var listItems = mutableListOf<FavoriteModel>()


    fun submitList(list: List<FavoriteModel>){
        this.listItems.clear()
        this.listItems = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = ItemsFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size //or 0
    }
}