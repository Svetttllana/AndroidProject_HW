package com.example.androidproject_hw.Presentation.view

import android.util.Log
import com.example.androidproject_hw.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    mainView = mainActivity
                }catch (e:Exception){
                    Log.w("exeption", " checkUserExists FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }

    fun checkUserExists() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val doesUserExists = authInteractor.checkUserExists()
                    mainView.userExistsResult(doesUserExists)
                }catch (e:Exception){
                    Log.w("exeption", " checkUserExists FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }
}