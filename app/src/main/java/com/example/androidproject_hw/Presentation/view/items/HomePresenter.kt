package com.example.androidproject_hw.Presentation.view.items

import com.example.androidproject_hw.domain.auth.AuthInteractor

import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var homeView: HomeView


    fun setView(homeFragment: HomeFragment) {
        homeView = homeFragment

    }

    fun showUserData() {
        val userName = authInteractor.getUserCreds().userName
        val userPassword = authInteractor.getUserCreds().userPassword
        homeView.userDataShow(userName, userPassword)

    }

    fun checkOnBoardFragm(){
        val doesOnBoarding = authInteractor.checkOnBoardFragm()
        homeView.onBoardingResult(doesOnBoarding)
      //  authInteractor.saveOnBoarding(ON_BOARDING)

    }




}