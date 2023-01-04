package com.example.androidproject_hw.Presentation.view.items

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentItems1Binding
import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.androidproject_hw.utils.AppConstans
import com.example.androidproject_hw.utils.AppConstans.DESCRIPTION
import com.example.androidproject_hw.utils.AppConstans.DETAILS

import com.example.androidproject_hw.utils.AppConstans.TIME
import com.example.androidproject_hw.utils.AppConstans.TITLE
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment1 : Fragment(), ItemsListener {

    private var _viewBinding: FragmentItems1Binding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()


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


        itemsAdapter = ItemsAdapter(this)



        viewBinding.recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.imageViewClick()
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.goToDetails()
        viewModel.bundl.observe(viewLifecycleOwner) { navBandl ->
            if (navBandl != null) {
                val detailsFragment = DetailsFragment1()
                val bundle = Bundle()
                bundle.putString(TITLE, navBandl.title)
                bundle.putString(DESCRIPTION, navBandl.description)
                bundle.putInt(AppConstans.IMAGE, navBandl.image)
                bundle.putString(TIME, navBandl.time)

                detailsFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, detailsFragment)
                    .addToBackStack(DETAILS)
                    .commit()
            }

        }

    }


    override fun onClick() {
        viewModel.imageViewClick()
    }

    override fun onElementSelected(
        title: String,
        description: String,
        imageView: Int,
        time: String
    ) {
        viewModel.elementClicked(imageView, title, description, time)
    }


}










