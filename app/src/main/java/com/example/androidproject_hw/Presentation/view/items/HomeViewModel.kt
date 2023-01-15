package com.example.androidproject_hw.Presentation.view.items

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.auth.AuthInteractor
import com.example.androidproject_hw.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
):ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds:LiveData<UserModel> = _userCreds

    private val _checkk = MutableLiveData<Boolean>()
    val checkk:LiveData<Boolean> = _checkk

    private val _nav = MutableLiveData<Int?>()
    val nav:LiveData<Int?> = _nav



    fun showUserData(){
        viewModelScope.launch {
            try {
                _userCreds.value=authInteractor.getUserCreds()
            }catch (e:Exception){
                Log.w("exeption", "showUserData FAILED")
            }

        }

    }

    fun checkOnBoardFragm(){
        viewModelScope.launch {
            try {
                _checkk.value= authInteractor.checkUserExists()
            }catch (e:Exception){  Log.w("exeption", "checkOnBoardFragm FAILED")}

        }


    }

    fun navigation(){
        viewModelScope.launch {
            try {
                _nav.value = R.navigation.main_graph
            }catch (e:Exception){Log.w("exeption", "navigation FAILED")}
        }

    }

}