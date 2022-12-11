package com.example.androidproject_hw.Presentation.view

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun goToDetails( title: String,
                     description: String,
                     imageView: Int,
                     time: String)

}