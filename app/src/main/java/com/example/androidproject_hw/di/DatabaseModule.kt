package com.example.androidproject_hw.di

import android.content.Context
import com.example.androidproject_hw.data.database.dao.ItemsDAO
import com.example.androidproject_hw.data.database.dao.ItemsDataBase
import dagger.Module
import dagger.Provides

@Module

class DatabaseModule {


    @Provides
    fun provideItemsDAO(itemsDatabase: ItemsDataBase): ItemsDAO {
        return itemsDatabase.getItemsDAO()
    }


    @Provides
    fun provideItemsDatabase(context: Context): ItemsDataBase {
        return ItemsDataBase.getItemsDatabaseInstance(context)

    }

}
