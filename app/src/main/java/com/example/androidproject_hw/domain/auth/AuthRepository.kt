package com.example.androidproject_hw.domain.auth

import com.example.androidproject_hw.model.UserModel

interface AuthRepository {

    suspend  fun loginUser(userName: String, userPassword: String)

    suspend  fun showUseCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend  fun userLogout()

    suspend   fun saveOnBoard(onBoard:String)

    suspend  fun doesOnBoardExists():Boolean

    suspend  fun navigation()

}