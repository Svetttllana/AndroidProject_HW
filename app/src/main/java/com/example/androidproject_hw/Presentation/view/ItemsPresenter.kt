package com.example.androidproject_hw.Presentation.view

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.ItemsInteractor
import com.example.clswrk_androidprojekt.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
) {


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