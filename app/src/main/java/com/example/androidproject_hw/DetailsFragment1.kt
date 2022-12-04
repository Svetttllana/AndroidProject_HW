package com.example.androidproject_hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView


class DetailsFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsTitle)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDescription)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)
        val detatilsTime = view.findViewById<TextView>(R.id.detailsTime)

        val bundle = arguments

        bundle?.let { safeBundle ->
            val name = safeBundle.getString("title")
            val date = safeBundle.getString("description")
            val image = safeBundle.getInt("imageView")
            val time = safeBundle.getString("time")

            detailsName.text = name
            detailsDate.text = date
            detatilsTime.text = time
            detailsImage.setBackgroundResource(image)

        }
    }

}