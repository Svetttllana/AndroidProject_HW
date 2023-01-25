package com.example.androidproject_hw.Presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ActivityMain2Binding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMain2Binding? = null
    private lateinit var navController: NavController

    @Inject

    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController


    }

    override fun userExistsResult(userExists: Boolean) {
        when (userExists) {
            true -> navController.setGraph(R.navigation.auth_graph)
            false -> navController.setGraph(R.navigation.main_graph)
        }


    }
}