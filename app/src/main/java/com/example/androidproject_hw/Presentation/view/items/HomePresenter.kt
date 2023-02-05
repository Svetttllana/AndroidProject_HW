package com.example.androidproject_hw.Presentation.view.items

import android.util.Log
import com.example.androidproject_hw.domain.auth.AuthInteractor
import com.example.androidproject_hw.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val itemsInteractor: ItemsInteractor
) {
    private lateinit var homeView: HomeView


    fun setView(homeFragment: HomeFragment) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    homeView = homeFragment
                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }

    fun showUserData() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val userName = authInteractor.getUserCreds().userName
                    val userPassword = authInteractor.getUserCreds().userPassword
                    homeView.userDataShow(userName, userPassword)
                }catch (e:Exception){
                    Log.w("exeption", " showUserData FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }

    fun showManagerData(){
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val list = itemsInteractor.showManagerData()
                    list.collect{
                        homeView.managerDataShow(it)
                    }
                }catch (e:Exception){
                    Log.w("exeption", " showManagerData FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }





}