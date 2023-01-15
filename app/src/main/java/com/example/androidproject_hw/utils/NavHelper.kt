package com.example.androidproject_hw.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object NavHelper {


    fun Fragment.navigated(destinationById:Int){
        findNavController().navigate(destinationById)
    }

    fun Fragment.changeGraph(graphById:Int){
        findNavController().setGraph(graphById)
    }

    fun Fragment.navigateWithBandl(destinationById: Int,bundle: Bundle) {
        findNavController().navigate(destinationById, bundle)
    }

}