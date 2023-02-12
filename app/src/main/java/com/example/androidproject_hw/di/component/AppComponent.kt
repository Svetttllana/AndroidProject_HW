package com.example.androidproject_hw.di.component

import com.example.androidproject_hw.di.*
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)

interface AppComponent {
}