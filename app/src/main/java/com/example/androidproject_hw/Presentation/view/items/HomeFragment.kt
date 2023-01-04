package com.example.androidproject_hw.Presentation.view.items

import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidproject_hw.Presentation.view.auth.OnBoardingFragment

import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentHomeBinding
import com.example.androidproject_hw.model.UserModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.showUserData()


        binding.btgoToNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, OnBoardingFragment())
                .commit()
        }

        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.tvUserCreads.text = "${it.userName} \n ${it.userPassword}"
        }


    }
}



