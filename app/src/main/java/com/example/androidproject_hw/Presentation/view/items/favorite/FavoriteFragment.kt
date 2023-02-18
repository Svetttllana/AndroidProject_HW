package com.example.androidproject_hw.Presentation.view.items.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject_hw.App
import com.example.androidproject_hw.Presentation.view.items.favorite.adapter.FavoriteAdapter
import com.example.androidproject_hw.Presentation.view.items.favorite.adapter.listener.FavoriteListener
import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.databinding.FragmentFavoriteBinding
import javax.inject.Inject

class FavoriteFragment : Fragment(), FavoriteListener, FavoriteView {

    @Inject
    lateinit var favoritesPresenter: FavoritePresenter

    private lateinit var favAdapter: FavoriteAdapter

    private var _binding: FragmentFavoriteBinding? = null
     private val binding  get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        favoritesPresenter.setView(this)

        favAdapter = FavoriteAdapter(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = favAdapter

        favoritesPresenter.getFavorites()

        favoritesPresenter.deliteFav(id)


    }

    override fun favReceived(list: List<FavoriteModel>) {
        favAdapter.submitList(list)
    }

    override fun deliteFav(id: Int) {
        Toast.makeText(context, "deleted favorite", Toast.LENGTH_SHORT).show()
    }

    override fun onDeliteClicked(id: Int) {
        favoritesPresenter.deliteFav(id)
    }


}
