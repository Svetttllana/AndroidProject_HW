package com.example.androidproject_hw.Presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.auth.AuthInteractor
import com.example.androidproject_hw.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor):ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav


    private val _check = MutableLiveData<Unit>()
    val check: LiveData<Unit> = _check

    fun loginUser(userName: String, userPassword: String) {

        authInteractor.loginUser(userName, userPassword)
        _nav.value = Unit
    }

    fun loginCheck() {
         _check.value=Unit


    }
}