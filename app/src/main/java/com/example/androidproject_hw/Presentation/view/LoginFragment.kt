package com.example.androidproject_hw.Presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.androidproject_hw.R
import com.example.androidproject_hw.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

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
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment1())
                    .commit()

            }

        }
    }
}