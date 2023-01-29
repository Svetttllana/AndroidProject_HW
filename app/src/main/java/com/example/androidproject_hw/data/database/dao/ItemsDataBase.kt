package com.example.androidproject_hw.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidproject_hw.data.database.dao.faventity.FavoriteEntity

@Database(entities = [ItemsEntity::class, FavoriteEntity::class], version = 1, exportSchema = false)
abstract class ItemsDataBase: RoomDatabase() {

    abstract fun getItemsDAO():ItemsDAO

    companion object{

        private const val DATABASE_NAME = "DATABASE_NAME"
        private var DB_INSTANCE:ItemsDataBase? = null

        fun getItemsDatabaseInstance(context: Context):ItemsDataBase{

            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDataBase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DB_INSTANCE = it }

        }












    }
}