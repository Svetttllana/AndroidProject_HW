package com.example.androidproject_hw.di

import com.example.androidproject_hw.data.ItemsRepositoryImpl
import com.example.androidproject_hw.domain.ItemsReposetory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract  fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ):ItemsReposetory

}