package com.example.androidproject_hw.domain.items

import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsReposetory {

  suspend fun getData()

  suspend fun showData():List<ItemsModel>

  suspend fun favClicked(itemsModel: ItemsModel)

  suspend fun deleteItemById(id: Int)

  suspend fun getFavorites(): List<FavoriteModel>

  suspend fun findItemById(id: Int): ItemsModel
}