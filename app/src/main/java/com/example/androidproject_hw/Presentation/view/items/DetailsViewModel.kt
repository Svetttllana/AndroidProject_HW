package com.example.androidproject_hw.Presentation.view.items

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.auth.AuthInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav


    fun logoutUser() {

        viewModelScope.launch {
            try {
                authInteractor.logoutUser()
                _nav.value = R.navigation.login_graph
            }catch (e:Exception){
                Log.w("exeption", "logoutUser FAILED")
            }

        }
    }
}

