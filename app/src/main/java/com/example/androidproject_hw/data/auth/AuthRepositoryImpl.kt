package com.example.androidproject_hw.data.auth

import com.example.androidproject_hw.domain.auth.AuthRepository
import com.example.androidproject_hw.model.UserModel
import com.example.androidproject_hw.data.sgaredPrefs.SharedPreferencesHelper
import com.example.androidproject_hw.model.OnBoardingModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
):AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
sharedPreferencesHelper.saveUserName(userName)
sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override fun showUseCreds():UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
      return  sharedPreferencesHelper.checkUserExists()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }

    override fun saveOnBoard(onBoard: String) {
        sharedPreferencesHelper.saveOnBoarding(onBoard)
    }

    override fun daesOnBoardExists(): Boolean {
    return   sharedPreferencesHelper.checknBoardFragment()
    }



}