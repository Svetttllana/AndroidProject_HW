package com.example.androidproject_hw.Presentation.view.items.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject_hw.Presentation.view.items.favorite.adapter.FavoriteAdapter
import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : Fragment(), FavoriteView {

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
        favoritesPresenter.setView(this)

        favAdapter = FavoriteAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = favAdapter

        favoritesPresenter.getFavorites()
    }

    override fun favReceived(list: List<FavoriteModel>) {
        favAdapter.submitList(list)
    }
}
