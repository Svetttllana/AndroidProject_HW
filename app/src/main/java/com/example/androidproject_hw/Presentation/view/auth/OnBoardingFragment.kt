package com.example.androidproject_hw.Presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.Presentation.view.items.ItemsFragment1
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentOnBoardingBinding
import com.example.androidproject_hw.utils.NavHelper.changeGraph
import com.example.androidproject_hw.utils.NavHelper.navigated
import dagger.hilt.android.AndroidEntryPoint
const val ON_BOARDING = "ON_BOARDING"
@AndroidEntryPoint
class OnBoardingFragment : Fragment() {



    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    private val viewModel:OnBoardingViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



binding.btNextFragm.setOnClickListener{
   viewModel.goToItemsFragment()
    viewModel.saveOnBoarding(ON_BOARDING)
}
        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null) {
                changeGraph(it)
            }

        }

   viewModel.save.observe(viewLifecycleOwner){
       if (it != null) {
           changeGraph(it)
       }
   }


    }




}