package com.example.androidproject_hw.Presentation.view.auth

import android.util.Log
import com.example.androidproject_hw.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {
    private lateinit var onBoardingView: OnBoardingView


    fun setView(onBoardingFragment: OnBoardingFragment) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    onBoardingView = onBoardingFragment
                }catch (e:Exception){
                    Log.w("exeption", "setView FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }

fun saveOnBoarding(onBoard:String){

    CoroutineScope(Dispatchers.Main).launch {
        val job = launch {
            try {
                authInteractor.saveOnBoarding(onBoard)
                onBoardingView.onBoardSave()
            }catch (e:Exception){
                Log.w("exeption", " saveOnBoarding FAILED")
            }

        }
        job.join()
        job.cancel()
    }


}

    fun checkOnBoardFragm(){
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val doesOnBoarding = authInteractor.checkOnBoardFragm()
                    onBoardingView.onBoardingResult(doesOnBoarding)
                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }



    }

}
