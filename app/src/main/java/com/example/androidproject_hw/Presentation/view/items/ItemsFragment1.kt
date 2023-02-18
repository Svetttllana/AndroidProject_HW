package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject_hw.App
import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.androidproject_hw.utils.AppConstans.EMAIL
import com.example.androidproject_hw.utils.AppConstans.ID
import com.example.androidproject_hw.utils.AppConstans.NAME
import com.example.androidproject_hw.utils.AppConstans.USER_NAME
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.databinding.FragmentItems1Binding
import com.example.clswrk_androidprojekt.model.ItemsModel
import javax.inject.Inject


class ItemsFragment1 : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItems1Binding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItems1Binding.inflate(inflater)
        return viewBinding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        itemsPresenter.setVIew(this)

        itemsAdapter = ItemsAdapter(this)

        viewBinding.recyclerView.adapter = itemsAdapter
        viewBinding.recyclerView.layoutManager =LinearLayoutManager(context)

        itemsPresenter.getData()


    }

    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun onElementSelected(
        name: String,
        userName: String,
        email: String,
        id: Int,
    ) {
        itemsPresenter.elementSelected(name,userName, email, id)

    }

    override fun onFavClicked(id: Int,fav: Boolean) {
        itemsPresenter.onFavClicked(id,fav)
    }

    override fun onDeliteClicked(id: Int) {
        itemsPresenter.deliteItem(id)
    }

    override fun updateFavorite(fav: Boolean, id: Int) {
        TODO("Not yet implemented")
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()

    }

    override fun goToDetails(
        name: String,
        userName: String,
        email: String,
        id: Int,
    ) {


        val bundle = Bundle()
        bundle.putString(NAME, name)
        bundle.putString(EMAIL, email)
        bundle.putInt(ID, id)
        bundle.putString(USER_NAME, userName)


        findNavController().navigate(
            R.id.action_itemsFragment1_to_detailsFragment1, bundle
        )


    }

    override fun deliteItem(id: Int) {
        Toast.makeText(context, getString(R.string.delited_item), Toast.LENGTH_SHORT).show()
    }

}


