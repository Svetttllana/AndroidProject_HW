package com.example.androidproject_hw.di.component

import com.example.androidproject_hw.Presentation.view.MainActivity
import com.example.androidproject_hw.Presentation.view.auth.LoginFragment
import com.example.androidproject_hw.Presentation.view.auth.OnBoardingFragment
import com.example.androidproject_hw.Presentation.view.items.DetailsFragment1
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.Presentation.view.items.ItemsFragment1
import com.example.androidproject_hw.Presentation.view.items.favorite.FavoriteFragment
import com.example.androidproject_hw.di.*
import com.example.androidproject_hw.di.factory.ScreenScope
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
@ScreenScope
interface AppComponent {


        fun inject(loginFragment: LoginFragment)
        fun inject(detailsFragment: DetailsFragment1)
        fun inject(favoriteFragment: FavoriteFragment)
        fun inject(itemsFragment: ItemsFragment1)
        fun inject(onBoardingFragment: OnBoardingFragment)
        fun inject(homeFragment: HomeFragment)
        fun inject(mainActivity: MainActivity)
    }
