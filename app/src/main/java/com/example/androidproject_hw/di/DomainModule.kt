package com.example.androidproject_hw.di

import com.example.androidproject_hw.domain.auth.AuthInteractor
import com.example.androidproject_hw.domain.auth.AuthRepository
import com.example.androidproject_hw.domain.items.ItemsInteractor
import com.example.androidproject_hw.domain.items.ItemsReposetory
import dagger.Module
import dagger.Provides

@Module

class DomainModule {

    @Provides
    fun providesItemsInteractor(
        itemsReposetory: ItemsReposetory
    ): ItemsInteractor {
        return ItemsInteractor(itemsReposetory)
    }

    @Provides
    fun providesAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}