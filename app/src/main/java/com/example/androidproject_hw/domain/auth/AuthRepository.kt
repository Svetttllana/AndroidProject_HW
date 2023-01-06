package com.example.androidproject_hw.domain.auth

import com.example.androidproject_hw.model.OnBoardingModel
import com.example.androidproject_hw.model.UserModel

interface AuthRepository {

    fun loginUser(userName:String,userPassword:String)


    fun showUseCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()


    ////
    fun saveOnBoard(onBoard:String)

    fun daesOnBoardExists():Boolean
//fun showOnBoardCreds():OnBoardingModel

}