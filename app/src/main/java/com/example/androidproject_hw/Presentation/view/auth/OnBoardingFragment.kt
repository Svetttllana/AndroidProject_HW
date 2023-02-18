package com.example.androidproject_hw.Presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.App
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding
import javax.inject.Inject

const val ON_BOARDING = "ON_BOARDING"


class OnBoardingFragment : Fragment(), OnBoardingView {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        onBoardingPresenter.setView(this)

            onBoardingPresenter.checkOnBoardFragm()

        binding.btNextFragm.setOnClickListener {

            onBoardingPresenter.saveOnBoarding(ON_BOARDING)
        }
    }

    override fun onBoardSave() {

            findNavController().navigate(R.id.action_onBoardingFragment_to_itemsFragment1)
        }




    override fun onBoardingResult(onBoardExists: Boolean) {

            if (onBoardExists) {
                findNavController().navigate(R.id.action_onBoardingFragment_to_itemsFragment1)


        }
    }
}