package com.example.androidproject_hw.domain.items

import com.example.clswrk_androidprojekt.model.ItemsModel

interface ItemsReposetory {

    fun getData():List<ItemsModel>
}