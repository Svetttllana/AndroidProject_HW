package com.example.androidproject_hw.Presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_hw.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val authInteractor: AuthInteractor
):ViewModel() {

    private val _userExists = MutableLiveData<Boolean>()
    val userExists : LiveData<Boolean> = _userExists


    fun checkUserExists() {

      _userExists.value =  authInteractor.checkUserExists()
    }


}