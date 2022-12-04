package com.example.clswrk_androidprojekt.adapter


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.R

import com.example.androidproject_hw.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel


class ItemsViewHolder(
    private var view: View,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(view) {


    fun bind(itemsModel: ItemsModel) {


        val title = view.findViewById<TextView>(R.id.tv_title)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val time = view.findViewById<TextView>(R.id.tv_time)


        title.text = itemsModel.title
        imageView.setBackgroundResource(itemsModel.image)
        time.text = itemsModel.time



        imageView.setOnClickListener {

            itemsListener.onClick()
        }



        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.title, itemsModel.description, itemsModel.image, itemsModel.time
            )

        }


    }

}


