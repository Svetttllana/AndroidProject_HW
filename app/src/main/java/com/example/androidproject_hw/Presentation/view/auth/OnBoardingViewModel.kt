package com.example.androidproject_hw.Presentation.view.auth

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
class OnBoardingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _save = MutableLiveData<Int?>()
    val save: LiveData<Int?> = _save

    fun goToItemsFragment() {
        viewModelScope.launch {
            try {
                _nav.value = R.navigation.main_graph
            } catch (e: Exception) {
                Log.w("exeption", "goToItemsFragment FAILED")
            }


        }

    }

    fun saveOnBoarding(onBoard: String) {
        viewModelScope.launch {
            try {
                authInteractor.saveOnBoard(onBoard)
                _save.value = R.navigation.main_graph
            } catch (e: Exception) {
                Log.w("exeption", "saveOnBoarding FAILED")
            }


        }

    }
}