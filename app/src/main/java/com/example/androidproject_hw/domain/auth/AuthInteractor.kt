package com.example.androidproject_hw.domain.auth

import com.example.androidproject_hw.model.OnBoardingModel
import com.example.androidproject_hw.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

    fun loginUser(userName: String, userPassword: String) {

        authRepository.loginUser(userName, userPassword)

    }

    fun getUserCreds(): UserModel {
        return authRepository.showUseCreds()
    }

    fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    fun logoutUser() {
        authRepository.userLogout()
    }


    fun saveOnBoarding(onBoard: String) {
        authRepository.saveOnBoard(onBoard)

    }


    fun checkOnBoardFragm(): Boolean {
        return authRepository.daesOnBoardExists()
    }


}