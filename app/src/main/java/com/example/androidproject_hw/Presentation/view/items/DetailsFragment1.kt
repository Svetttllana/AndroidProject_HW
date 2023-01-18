package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.Presentation.view.auth.LoginFragment
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentDetails1Binding
import com.example.androidproject_hw.utils.AppConstans.DESCRIPTION
import com.example.androidproject_hw.utils.AppConstans.IMAGE
import com.example.androidproject_hw.utils.AppConstans.TIME
import com.example.androidproject_hw.utils.AppConstans.TITLE
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment1 : Fragment(), DetailsView {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private var _viewBinding: FragmentDetails1Binding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetails1Binding.inflate(inflater)
        return viewBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        detailsPresenter.setView(this)

        val bundle = arguments

        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(TITLE),
                safeBundle.getString(DESCRIPTION),
                safeBundle.getString(TIME),
                safeBundle.getInt(IMAGE)
            )


        }


        viewBinding.btnLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }

    }

    override fun logoutUser() {
        findNavController().setGraph(R.navigation.auth_graph)
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.activity_container, LoginFragment())
//            .commit()
    }

    override fun displayItemData(title: String, description: String, time: String, image: Int) {
        viewBinding.detailsTitle.text = title
        viewBinding.detailsDescription.text = description
        viewBinding.detailsTime.text = time
        viewBinding.detailsImage.setBackgroundResource(image)
    }

}