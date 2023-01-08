package com.example.androidproject_hw.data.sgaredPrefs

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.androidproject_hw.model.OnBoardingModel
import com.example.androidproject_hw.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?) {
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds(): UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: "no user"
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: "no user"
        return UserModel(name, password)
    }

    fun checkUserExists(): Boolean {
        val name = sharedPreferences.getString(USER_NAME, "")
        val password = sharedPreferences.getString(USER_PASSWORD, "")
        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())

    }

    fun removeUser() {
        saveUserName(null)
        saveUserPassword(null)
        saveOnBoarding(null)

    }


    fun saveOnBoarding(onBoard: String?) {
        sharedPreferences.edit().putString(ON_BOARDING, onBoard).apply()
    }


    fun checknBoardFragment(): Boolean {
        val onBoard = sharedPreferences.getString(ON_BOARDING, "")
        return (!onBoard.isNullOrEmpty())

    }


    companion object {
        const val USER_NAME = "USER NAME"
        const val USER_PASSWORD = "USER PASSWORD"
        const val ON_BOARDING = "ON_BOARDING"
    }

}