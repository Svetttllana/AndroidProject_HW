package com.example.androidproject_hw.di;

import com.example.androidproject_hw.Presentation.view.auth.LoginPresenter
import com.example.androidproject_hw.Presentation.view.auth.OnBoardingPresenter
import com.example.androidproject_hw.Presentation.view.items.HomePresenter
import com.example.androidproject_hw.Presentation.view.items.ItemsPresenter
import com.example.androidproject_hw.domain.auth.AuthInteractor
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
    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor):LoginPresenter{
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter():OnBoardingPresenter{
        return OnBoardingPresenter()
    }


    @Provides
    fun provideHomePresenter(authInteractor: AuthInteractor): HomePresenter {
        return HomePresenter(authInteractor)
    }




}