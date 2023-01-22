package com.example.androidproject_hw.Presentation.view.items

interface DetailsView {

    fun logoutUser()
    fun displayItemData(
        name: String, userName: String, email: String)
}