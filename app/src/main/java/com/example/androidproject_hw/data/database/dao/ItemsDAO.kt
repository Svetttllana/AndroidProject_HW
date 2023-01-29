package com.example.androidproject_hw.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.androidproject_hw.data.database.dao.faventity.FavoriteEntity
import com.example.clswrk_androidprojekt.model.ItemsModel

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity ")
    fun getItemsEntity(): List<ItemsModel>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) != 0")
    fun doesItemsEntityExist(): Boolean

    @Query("DELETE FROM ItemsEntity WHERE id =:id")
    fun deleteItemEntityById(id: Int)

    @Query("SELECT * FROM ItemsEntity WHERE id =:id")
    fun findItemEntityById(id: Int): ItemsEntity

    @Insert(onConflict = IGNORE)
    fun insetFavoritesEntity(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM FavoriteEntity")
    fun getFavoritesEntities(): List<FavoriteEntity>
}