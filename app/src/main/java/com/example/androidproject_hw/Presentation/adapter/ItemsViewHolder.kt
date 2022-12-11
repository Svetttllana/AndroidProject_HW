package com.example.clswrk_androidprojekt.adapter


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.ItemsCatsBinding

import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel


class ItemsViewHolder(
    private var viewBinding: ItemsCatsBinding,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(itemsModel: ItemsModel) {


       viewBinding.tvTitle.text = itemsModel.title
       viewBinding.ivImage.setBackgroundResource(itemsModel.image)
        viewBinding.tvTime.text = itemsModel.time

      viewBinding.ivImage.setOnClickListener {

            itemsListener.onClick()
        }



        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.title, itemsModel.description, itemsModel.image, itemsModel.time
            )

        }


    }

}


