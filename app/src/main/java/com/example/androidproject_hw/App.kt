package com.example.androidproject_hw

import android.app.Application
import com.example.androidproject_hw.di.AppModule
import com.example.androidproject_hw.di.component.AppComponent
import com.example.androidproject_hw.di.component.DaggerAppComponent


class App:Application(){

    lateinit var appComponent: AppComponent
    fun provideAppComponent():AppComponent{
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}