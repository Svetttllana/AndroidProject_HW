package com.example.androidproject_hw.Presentation.view.items


import com.example.androidproject_hw.R


import com.example.androidproject_hw.domain.items.ItemsInteractor
import javax.inject.Inject


class ItemsPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {
    private lateinit var itemsView: ItemsView

    fun setVIew(itemsFragment1: ItemsFragment1) {
        itemsView = itemsFragment1
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

        itemsView.goToDetails(title=title, description=description, imageView=imageView, time=time)


    }

}