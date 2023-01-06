package com.example.androidproject_hw.Presentation.view.auth

import com.example.androidproject_hw.domain.auth.AuthInteractor
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {
    private lateinit var onBoardingView: OnBoardingView


    fun setView(onBoardingFragment: OnBoardingFragment) {
        onBoardingView = onBoardingFragment

    }

    fun goToItemsFragment() {
        onBoardingView.goToItemsFragment()

    }
fun saveOnBoarding(onBoard:String){
    authInteractor.saveOnBoarding(onBoard)
    onBoardingView.onBoardSave()

}

}
