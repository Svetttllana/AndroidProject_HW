package com.example.androidproject_hw

import com.example.androidproject_hw.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor( private val authInteractor: AuthInteractor) {

    lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView=mainActivity

    }

    fun checkUserExists(){
      val userExists =  authInteractor.checkUserExists()
        mainView.checkUserExists(userExists)

    }
}