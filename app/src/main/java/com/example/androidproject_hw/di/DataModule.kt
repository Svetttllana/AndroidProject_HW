package com.example.androidproject_hw.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidproject_hw.data.auth.AuthRepositoryImpl
import com.example.androidproject_hw.data.items.ItemsRepositoryImpl
import com.example.androidproject_hw.domain.auth.AuthRepository
import com.example.androidproject_hw.domain.items.ItemsReposetory
import com.example.androidproject_hw.data.sgaredPrefs.SharedPreferencesHelper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract  fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsReposetory


    @Binds
    abstract  fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository



    companion object{

       private const val SP_KEY = "SP_KEY"

        @Provides

        fun provideSharedPreferences(
            @ApplicationContext context: Context): SharedPreferencesHelper {
            return SharedPreferencesHelper(

                context.getSharedPreferences(SP_KEY,MODE_PRIVATE)
            )

        }
    }

}