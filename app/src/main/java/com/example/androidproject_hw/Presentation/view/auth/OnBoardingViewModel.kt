package com.example.androidproject_hw.Presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_hw.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
):ViewModel() {

private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _save = MutableLiveData<Unit?>()
    val save: LiveData<Unit?> = _save

    fun goToItemsFragment(){
      _nav.value=Unit
    }

    fun saveOnBoarding(onBoard:String){
        authInteractor.saveOnBoard(onBoard)
        _save.value=Unit
    }

}