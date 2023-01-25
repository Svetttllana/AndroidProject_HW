package com.example.clswrk_androidprojekt.model

import com.example.androidproject_hw.data.model.Address
import com.example.androidproject_hw.data.model.Company
import com.example.androidproject_hw.data.model.Geo

data class ItemsModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val suite: String,
    val street: String,
    val city: String,
    val zipcode: String,
    val lat: String,
    val lng: String,
    val phone: String,
    val website: String,
      val nameCompany: String,
    val catchPhrase: String,
    val bs: String

)