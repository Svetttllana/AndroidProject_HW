package com.example.androidproject_hw.Presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.androidproject_hw.Presentation.view.auth.LoginFragment
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMain2Binding? = null

    @Inject
 lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()


    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when (userExists) {
                true -> HomeFragment()
                false -> LoginFragment()
            }
        )
            .commit()


    }
}