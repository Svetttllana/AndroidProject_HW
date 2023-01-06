package com.example.androidproject_hw.Presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject_hw.Presentation.view.items.ItemsFragment1
import com.example.androidproject_hw.R
import com.example.androidproject_hw.data.sgaredPrefs.SharedPreferencesHelper
import com.example.androidproject_hw.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
const val ON_BOARDING="ON_BOARDING"
@AndroidEntryPoint

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

        onBoardingPresenter.setView(this)

binding.btNextFragm.setOnClickListener{
    onBoardingPresenter.goToItemsFragment()
    onBoardingPresenter.saveOnBoarding(ON_BOARDING)
}



     }

    override fun goToItemsFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, ItemsFragment1())
            .commit()
    }

    override fun onBoardSave() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, ItemsFragment1())
            .commit()
    }


}