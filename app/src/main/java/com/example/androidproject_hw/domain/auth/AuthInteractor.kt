package com.example.androidproject_hw.domain.auth

import com.example.androidproject_hw.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

   suspend fun loginUser(userName: String, userPassword: String) {

        authRepository.loginUser(userName, userPassword)

    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUseCreds()
    }

    suspend  fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    suspend  fun logoutUser() {
        authRepository.userLogout()
    }

    suspend  fun saveOnBoard(onBoard: String) {
        authRepository.saveOnBoard(onBoard)
    }

    suspend  fun checkOnBoardFragment(): Boolean {
        return authRepository.doesOnBoardExists()
    }

    suspend  fun navigation(){
        return authRepository.navigation()
    }


}