package com.example.androidproject_hw.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidproject_hw.data.ItemsEntity
import com.example.clswrk_androidprojekt.model.ItemsModel

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)


@Query("SELECT * From ItemsEntity ")
    fun getItemsEntity():List<ItemsModel>


    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) != 0")
    fun doesItemsEntityExist():Boolean


}