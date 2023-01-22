package com.example.androidproject_hw.Presentation.adapter.listener

interface ItemsListener {

    fun onClick()


    fun onElementSelected(name:String, userName:String,email:String,id:Int)

}