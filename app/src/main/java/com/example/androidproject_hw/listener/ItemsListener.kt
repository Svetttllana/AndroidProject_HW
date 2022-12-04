package com.example.androidproject_hw.listener

interface ItemsListener {

    fun onClick()



    fun onElementSelected(title:String, description:String, imageView:Int, time: String)

}