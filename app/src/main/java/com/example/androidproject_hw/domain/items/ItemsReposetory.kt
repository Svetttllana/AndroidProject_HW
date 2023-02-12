package com.example.androidproject_hw.domain.items

import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.flow.Flow

interface ItemsReposetory {

  suspend fun getData()

  suspend fun showData(): Flow<List<ItemsModel>>

  suspend fun favClicked(itemsModel: ItemsModel,fav: Boolean)

  suspend fun getFavorites(): List<FavoriteModel>

  suspend fun findItemById(id: Int): ItemsModel

  suspend fun deleteItemById(id: Int)

  suspend fun deliteFavById(id: Int)


}