package com.example.androidproject_hw.di;

import com.example.androidproject_hw.Presentation.view.ItemsPresenter
import com.example.androidproject_hw.domain.ItemsInteractor
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

@Provides
    fun providesItemsPresenter(
    itemsInteractor: ItemsInteractor
):ItemsPresenter{
        return ItemsPresenter(itemsInteractor)
    }


}