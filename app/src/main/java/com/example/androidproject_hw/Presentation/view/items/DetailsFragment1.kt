package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentDetails1Binding
import com.example.androidproject_hw.utils.AppConstans.EMAIL
import com.example.androidproject_hw.utils.AppConstans.NAME
import com.example.androidproject_hw.utils.AppConstans.USER_NAME
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
                safeBundle.getString(NAME),
                safeBundle.getString(EMAIL),
                safeBundle.getString(USER_NAME))


        }


        viewBinding.btLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }

    }

    override fun logoutUser() {
        findNavController().setGraph(R.navigation.auth_graph)

    }

    override fun displayItemData(
        name: String, userName: String, email: String
    ) {
        viewBinding.tvName.text = name
        viewBinding.tvEmail.text = email
        viewBinding.tvUsername.text = userName


    }

}