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

        val detailsTitle = view.findViewById<TextView>(R.id.detailsTitle)
        val detailsDescription = view.findViewById<TextView>(R.id.detailsDescription)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)
        val detatilsTime = view.findViewById<TextView>(R.id.detailsTime)

        val bundle = arguments

        bundle?.let { safeBundle ->
            val title = safeBundle.getString(TITLE)
            val description = safeBundle.getString(DESCRIPTION)
            val image = safeBundle.getInt(IMAGE)
            val time = safeBundle.getString(TIME)

            detailsTitle.text = title
            detailsDescription.text = description
            detatilsTime.text = time
            detailsImage.setBackgroundResource(image)

        }
    }

}