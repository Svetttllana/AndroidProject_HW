package com.example.androidproject_hw.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsReposetory {

  suspend fun getData()

  suspend fun showData():List<ItemsModel>
}