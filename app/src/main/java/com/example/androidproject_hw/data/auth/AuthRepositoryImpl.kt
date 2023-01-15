package com.example.androidproject_hw.data.auth

import com.example.androidproject_hw.domain.auth.AuthRepository
import com.example.androidproject_hw.model.UserModel
import com.example.androidproject_hw.data.sgaredPrefs.SharedPreferencesHelper
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
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.removeUser()
        }
    }

    override suspend fun saveOnBoard(onBoard: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveOnBoarding(onBoard)
        }
    }

    override suspend fun doesOnBoardExists(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checknBoardFragment()
        }
    }

    override suspend fun navigation() {
        withContext(Dispatchers.IO){

        }
    }

}