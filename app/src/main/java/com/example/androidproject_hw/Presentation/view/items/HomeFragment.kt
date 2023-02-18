package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.App
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentHomeBinding
import javax.inject.Inject


class HomeFragment : Fragment(), HomeView {


    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    @Inject
    lateinit var homePresenter: HomePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)


        homePresenter.setView(this)

        homePresenter.showUserData()

        binding.btgoToOnBoarding.setOnClickListener {
            findNavController().setGraph(R.navigation.main_graph)
        //    homePresenter.checkOnBoardFragm()

        }


    }


    override fun userDataShow(userName: String, userPassword: String) {
        binding.tvUserCreads.text = "${userName} \n ${userPassword}"


    }



}

