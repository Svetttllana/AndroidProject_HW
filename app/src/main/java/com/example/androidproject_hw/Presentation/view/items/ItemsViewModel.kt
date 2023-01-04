package com.example.androidproject_hw.Presentation.view.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.items.ItemsInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val itemsInteractor: ItemsInteractor) :
    ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundl = MutableLiveData<NavigateWithBundle?>()
    val bundl: LiveData<NavigateWithBundle?> = _bundl


    fun getData() {
        val listItems = itemsInteractor.getData()

        _items.value = listItems
    }

    fun imageViewClick() {
        _msg.value = R.string.imageview_clicked

    }

    fun goToDetails(){
        _bundl.value=null
    }

    fun elementClicked( imageView: Int,title: String, description: String, time:String) {

        _bundl.value = NavigateWithBundle(title = title, description = description, image = imageView, time = time)
    }

}

data class NavigateWithBundle(
    val image: Int,
    val title: String,
    val description: String,
    val time: String

)