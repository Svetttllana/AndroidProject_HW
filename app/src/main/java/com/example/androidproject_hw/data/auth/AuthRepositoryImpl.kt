package com.example.androidproject_hw.data.auth

import com.example.androidproject_hw.domain.auth.AuthRepository
import com.example.androidproject_hw.model.UserModel
import com.example.androidproject_hw.data.sgaredPrefs.SharedPreferencesHelper
import com.example.androidproject_hw.model.OnBoardingModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUseCreds(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.getUserCreds()
        }
    }


    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checkUserExists()
        }
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.removeUser()
        }

    }

    suspend override fun saveOnBoard(onBoard: String) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveOnBoarding(onBoard)
        }

    }

    suspend override fun daesOnBoardExists(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checknBoardFragment()
        }
    }


}