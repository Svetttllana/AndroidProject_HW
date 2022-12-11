package com.example.androidproject_hw.Presentation.adapter.listener

interface ItemsListener {

    fun onClick()


    fun onElementSelected(title: String, description: String, imageView: Int, time: String)

}