package com.example.androidproject_hw.Presentation.view.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(msg:Int)

    fun goToDetails(name: String,
                     userName: String,
                    email: String,
                     id: Int
                     )

}