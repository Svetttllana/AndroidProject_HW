package com.example.androidproject_hw.di

import com.example.androidproject_hw.domain.ItemsInteractor
import com.example.androidproject_hw.domain.ItemsReposetory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesItemsInteractor(
        itemsReposetory: ItemsReposetory
    ): ItemsInteractor {
        return ItemsInteractor(itemsReposetory)
    }
}