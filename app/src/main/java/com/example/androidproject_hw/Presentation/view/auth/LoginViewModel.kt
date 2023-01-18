package com.example.androidproject_hw.Presentation.view.auth

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
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav


    private val _check = MutableLiveData<Unit>()
    val check: LiveData<Unit> = _check

    fun loginUser(userName: String, userPassword: String) {

        viewModelScope.launch {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.value =R.id.action_loginFragment_to_homeFragment
            } catch (e: Exception) {
                Log.w("exeption", "loginUser FAILED")
            }

        }
    }

    fun loginCheck() {
        viewModelScope.launch {
            try {

            }catch (e:Exception){
                Log.w("exeption","loginCheck FAILED" )
            }
            _check.value = Unit
        }
    }

    fun userNavigatedValue(){
        _nav.value=null
    }
}