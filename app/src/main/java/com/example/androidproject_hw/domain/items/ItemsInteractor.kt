package com.example.androidproject_hw.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsReposetory: ItemsReposetory) {

suspend  fun getData():List<ItemsModel>{
      return itemsReposetory.getData()
    }


}