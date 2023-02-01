package com.example.androidproject_hw.Presentation.view.items.favorite

import com.example.androidproject_hw.model.FavoriteModel

interface FavoriteView {

    fun favReceived (list: List<FavoriteModel>)

   fun deliteFav(id:Int)
}