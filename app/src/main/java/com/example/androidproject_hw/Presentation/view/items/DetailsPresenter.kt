package com.example.androidproject_hw.Presentation.view.items

import com.example.androidproject_hw.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
  private val  authInteractor: AuthInteractor
) {
    private lateinit var detailsView:DetailsView

    fun setView(detailsFragment1: DetailsFragment1){
        detailsView=detailsFragment1
    }

    fun logoutUser(){
        authInteractor.logoutUser()

        detailsView.logoutUser()
    }

    fun getArguments(title:String?,description:String?,time: String?,image:Int) {
        detailsView.displayItemData(
            when (title.isNullOrBlank()) {

                true -> "no data"
                false -> title
            },
            when (description.isNullOrEmpty()) {
                true -> " no date"
                false -> description

            },
            when(time.isNullOrEmpty()){
                true -> "no date"
                false -> time
            },
            image)

    }

}