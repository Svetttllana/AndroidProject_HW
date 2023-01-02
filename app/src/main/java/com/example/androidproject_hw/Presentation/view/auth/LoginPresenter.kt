package com.example.androidproject_hw.Presentation.view.auth

import com.example.androidproject_hw.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
private val authInteractor: AuthInteractor
) {
    private lateinit var loginVIew: LoginVIew


    fun setView(loginFragment: LoginFragment){

        loginVIew=loginFragment
    }

    fun loginUser(userName:String, userPassword:String){
        authInteractor.loginUser(userName,userPassword)
        loginVIew.userLoggedIn()

    }


}