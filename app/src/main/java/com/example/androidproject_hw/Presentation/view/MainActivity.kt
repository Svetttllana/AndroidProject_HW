package com.example.androidproject_hw.Presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidproject_hw.App
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ActivityMain2Binding
import javax.inject.Inject


class MainActivity : AppCompatActivity(),MainView,
    NavController.OnDestinationChangedListener
{

    private  var _binding: ActivityMain2Binding?=null
    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).provideAppComponent().inject(this)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        mainPresenter.setView(this)
        mainPresenter.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.loginFragment) {
                _binding!!.buttomNavigation.visibility = GONE
            } else {
                _binding!!.buttomNavigation.visibility = VISIBLE
            }
        }
        _binding!!.buttomNavigation.setupWithNavController(navController)
    }


    override fun userExistsResult(userExists: Boolean) {
        when (userExists) {
            true -> navController.setGraph(R.navigation.auth_graph)
            false -> navController.setGraph(R.navigation.main_graph)
        }


    }


    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {

    }
    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }


}
