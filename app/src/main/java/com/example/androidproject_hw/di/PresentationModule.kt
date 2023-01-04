package com.example.androidproject_hw.di;

import com.example.androidproject_hw.domain.items.ItemsInteractor
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent::class)

class PresentationModule {

@Provides
    fun providesItemsPresenter(
    itemsInteractor: ItemsInteractor
): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }




}