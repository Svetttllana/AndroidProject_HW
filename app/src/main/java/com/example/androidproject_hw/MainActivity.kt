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
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMain2Binding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        viewModel.checkUserExists()

        viewModel.userExists.observe(this){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.activity_container,
               when(it){
                   true -> HomeFragment()
                   false -> LoginFragment()
               }
            )
            fragmentTransaction.commit()
        }



    }
}