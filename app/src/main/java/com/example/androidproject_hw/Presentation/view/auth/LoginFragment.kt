package com.example.androidproject_hw.Presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidproject_hw.Presentation.view.items.DetailsFragment1
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.Presentation.view.items.ItemsFragment1
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginVIew {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)


        viewBinding.btSignIn.setOnClickListener {

            if (viewBinding.etLog.text.toString().isEmpty() && viewBinding.etPass.text.toString()
                    .isEmpty()
            ) {
                viewBinding.etLog.error = getString(R.string.LogCantBeEmpty)
                viewBinding.etPass.error = getString(R.string.PassCantBeEmpty)

            } else if (viewBinding.etLog.text.toString().isEmpty()) {
                viewBinding.etLog.error = getString(R.string.LogCantBeEmpty)
            } else if (viewBinding.etPass.text.toString().isEmpty()) {
                viewBinding.etPass.error = getString(R.string.PassCantBeEmpty)
            } else {
                parentFragmentManager
                findNavController().setGraph(R.navigation.main_graph)

            }

        }


        viewBinding.btShowCreds.setOnClickListener {
            loginPresenter.loginUser(
                viewBinding.etLog.text.toString(),
                viewBinding.etPass.text.toString()
            )
        }


    }

    override fun userLoggedIn() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }
}