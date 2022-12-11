package com.example.androidproject_hw.Presentation.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentItems1Binding
import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.androidproject_hw.data.ItemsRepositoryImpl
import com.example.androidproject_hw.domain.ItemsInteractor
import com.example.androidproject_hw.utils.AppConstans
import com.example.androidproject_hw.utils.AppConstans.DESCRIPTION
import com.example.androidproject_hw.utils.AppConstans.DETAILS

import com.example.androidproject_hw.utils.AppConstans.TIME
import com.example.androidproject_hw.utils.AppConstans.TITLE
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.model.ItemsModel
import java.util.*

class ItemsFragment1 : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItems1Binding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItems1Binding.inflate(inflater)
        return viewBinding.root

    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)

        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()


    }


    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }


    override fun onElementSelected(
        title: String,
        description: String,
        imageView: Int,
        time: String
    ) {
        itemsPresenter.elementSelected(title, description, imageView, time)

    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()

    }

    override fun goToDetails(
        title: String,
        description: String,
        imageView: Int,
        time: String
    ) {

        val detailsFragment = DetailsFragment1()
        val bundle = Bundle()
        bundle.putString(TITLE, title)
        bundle.putString(DESCRIPTION, description)
        bundle.putInt(AppConstans.IMAGE, imageView)
        bundle.putString(TIME, time)

        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(DETAILS)
            .commit()

    }


}


