package com.example.androidproject_hw

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.listener.ItemsListener
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.model.ItemsModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ItemsFragment1 : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items1, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        // у фрагмента нет контекста. закрепляем как фрагмнт
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->

            val detailsFragment = DetailsFragment1()
            val bundle = Bundle()
            bundle.putString(TITLE, navBundle.title)
            bundle.putString(DESCRIPTION, navBundle.description)
            bundle.putInt(IMAGE, navBundle.image)
            bundle.putString(TIME, navBundle.time)

            detailsFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .addToBackStack(DETAILS)
                .commit()
        }
    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }


    override fun onElementSelected(
        title: String,
        description: String,
        imageView: Int,
        time: String
    ) {
        viewModel.elementClicked(title, description, imageView, time)
    }


}


