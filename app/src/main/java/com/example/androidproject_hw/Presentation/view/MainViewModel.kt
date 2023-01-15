package com.example.androidproject_hw.Presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val authInteractor: AuthInteractor
):ViewModel() {

    private val _userExists = MutableLiveData<Boolean>()
    val userExists : LiveData<Boolean> = _userExists

    private val _nav = MutableLiveData<Int>()
    val nav : LiveData<Int> = _nav


    fun checkUserExists() {

        viewModelScope.launch {
            try {
                _userExists.value =  authInteractor.checkUserExists()
            }catch (E:Exception){
                Log.w("exeption", " checkUserExists FAILED")
            }
           }

    }

    fun navigation(){
        viewModelScope.launch {
            val it = authInteractor.checkUserExists()

                _nav.value =   when (it) {
                    true -> R.navigation.main_graph
                    false -> R.navigation.login_graph
                }


        }

    }



}