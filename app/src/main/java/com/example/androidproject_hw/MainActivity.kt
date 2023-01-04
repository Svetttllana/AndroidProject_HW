package com.example.androidproject_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.androidproject_hw.Presentation.view.auth.LoginFragment
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMain2Binding? = null

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()



    }

    override fun checkUserExists(userExists:Boolean){
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_container,
                when(userExists){
                    true -> HomeFragment()
                    false -> LoginFragment()
                }
            )
            .commit()



    }
}