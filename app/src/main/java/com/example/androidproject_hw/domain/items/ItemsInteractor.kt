package com.example.androidproject_hw.domain.items

import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsReposetory: ItemsReposetory) {

suspend  fun getData(){
      return itemsReposetory.getData()
    }



    suspend  fun showData(): List<ItemsModel>{
        return itemsReposetory.showData()
    }

    suspend fun findItemById(id: Int): ItemsModel{
        return itemsReposetory.findItemById(id)
    }

    suspend fun onFavClicked(id: Int){
        val foundItem = findItemById(id)
        itemsReposetory.favClicked(foundItem)
    }

    suspend fun getFavorites(): List<FavoriteModel>{
        return itemsReposetory.getFavorites()
    }
}