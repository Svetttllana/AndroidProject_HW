package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.model.ManagerModel
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentHomeBinding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
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

    override fun managerDataShow(list: List<ManagerModel>) {
        binding.tvManager.text="${list}"
    }


}

