package com.example.androidproject_hw.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsReposetory {

  suspend fun getData():List<ItemsModel>
}