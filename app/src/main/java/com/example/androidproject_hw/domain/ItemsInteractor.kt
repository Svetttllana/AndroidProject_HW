package com.example.androidproject_hw.domain

import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsInteractor(private val itemsReposetory: ItemsReposetory) {

    fun getData():List<ItemsModel>{
      return itemsReposetory.getData()
    }


}