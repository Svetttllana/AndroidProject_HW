package com.example.androidproject_hw.Presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.Presentation.view.auth.LoginFragment
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Boolean
import javax.inject.Inject

const val ON_BOARDING = "ON_BOARDING"
@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMain2Binding? = null
    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var navHostFragm: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        viewModel.checkUserExists()

        val navHostFragm = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                as NavHostFragment

        navController = navHostFragm.navController



        viewModel.nav.observe(this) {

            navController.setGraph(it)

        }

    }

//    private fun getNavGraph(): NavGraph {
//        val navGraph = navHostFragm.navController.navInflater.inflate(
//            R.navigation.login_graph
//        )
//
//        val boolean =Boolean(ON_BOARDING)
//        //val random = (1..3).random()
//          if (boolean == true) {
//            navGraph.startDestination = R.id.onBoardingFragment
//        } else {
//            navGraph.startDestination = R.id.detailsFragment1
//        }
//
//        return  navGraph
//
//    }



}