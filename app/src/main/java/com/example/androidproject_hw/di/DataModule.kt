package com.example.androidproject_hw.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidproject_hw.data.ApiService
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsReposetory


    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository


    companion object {

        private const val SP_KEY = "SP_KEY"
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        @Provides

        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(

                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)
            )

        }


        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)


        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

}