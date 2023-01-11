package com.example.androidproject_hw.Presentation.view.auth

import android.util.Log
import com.example.androidproject_hw.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var loginVIew: LoginVIew


    fun setView(loginFragment: LoginFragment) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    loginVIew = loginFragment
                }catch (e:Exception){
                    Log.w("exeption", " loginUser FAILED")
                }

            }
            job.join()
            job.cancel()
        }

    }

    fun loginUser(userName: String, userPassword: String) {
       CoroutineScope(Dispatchers.Main).launch {
           val job = launch {
               try {
                   authInteractor.loginUser(userName, userPassword)
                   loginVIew.userLoggedIn()
               }catch (e:Exception){
                   Log.w("exeption", " loginUser FAILED")
               }

           }
           job.join()
           job.cancel()
        }


    }


}