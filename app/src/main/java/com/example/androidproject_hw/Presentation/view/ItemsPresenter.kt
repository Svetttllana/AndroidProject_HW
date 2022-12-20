package com.example.androidproject_hw.Presentation.view


import com.example.androidproject_hw.R


import com.example.androidproject_hw.domain.ItemsInteractor
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject



class ItemsPresenter @Inject constructor(
       private val itemsInteractor: ItemsInteractor
) {
    private lateinit var itemsView:ItemsView

    fun setVIew(context:ItemsView){
        itemsView=context
    }


    fun getData() {
        val listItems = itemsInteractor.getData()

        itemsView.dataReceived(listItems)

    }
    fun imageViewClicked() {

        itemsView.imageViewClicked(R.string.imageview_clicked)


    }

    fun elementSelected(
        title: String,
        description: String,
        imageView: Int,
        time: String
    ) {

        itemsView.goToDetails(title, description, imageView, time)


    }

}