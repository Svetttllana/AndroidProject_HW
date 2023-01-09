package com.example.androidproject_hw.Presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels

import com.example.androidproject_hw.Presentation.view.items.DetailsFragment1
import com.example.androidproject_hw.Presentation.view.items.HomeFragment
import com.example.androidproject_hw.Presentation.view.items.ItemsFragment1
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

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




        viewBinding.btSignIn.setOnClickListener {
            viewModel.loginCheck()
        }

        viewModel.check.observe(viewLifecycleOwner) { logResult ->
            if (viewBinding.etLog.text.toString()
                    .isEmpty() && viewBinding.etPass.text.toString()
                    .isEmpty()
            ) {
                viewBinding.etLog.error = getString(R.string.LogCantBeEmpty)
                viewBinding.etPass.error = getString(R.string.PassCantBeEmpty)

            } else if (viewBinding.etLog.text.toString().isEmpty()) {
                viewBinding.etLog.error = getString(R.string.LogCantBeEmpty)
            } else if (viewBinding.etPass.text.toString().isEmpty()) {
                viewBinding.etPass.error = getString(R.string.PassCantBeEmpty)
            } else {
                viewModel.check.observe(viewLifecycleOwner) {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.activity_container, ItemsFragment1())
                        .commit()
                }
            }
        }



            viewBinding.btShowCreds.setOnClickListener {
                viewModel.loginUser(
                    viewBinding.etLog.text.toString(),
                    viewBinding.etPass.text.toString()
                )
            }

            viewModel.nav.observe(viewLifecycleOwner) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
            }
        }


    }
