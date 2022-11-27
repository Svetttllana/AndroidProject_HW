package com.example.androidproject_hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val login = view.findViewById<EditText>(R.id.edTex_login)
        val password = view.findViewById<EditText>(R.id.edTex_password)
        val btSignIn = view.findViewById<Button>(R.id.btnSignIn)


        val btnRegestration = view.findViewById<Button>(R.id.btnRegestration)

        btSignIn.setOnClickListener {

            if (login.text.toString().isEmpty() && password.text.toString().isEmpty()) {
                login.error = getString(R.string.LogCantBeEmpty)
                password.error = getString(R.string.PassCantBeEmpty)

            } else if (login.text.toString().isEmpty()) {
                login.error = getString(R.string.LogCantBeEmpty)
            } else if (password.text.toString().isEmpty()) {
                password.error = getString(R.string.PassCantBeEmpty)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.actContainer, MainScreenFragment())
                    .commit()

            }

        }

        btnRegestration.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .add(R.id.actContainer, SignUpFragment())
                .addToBackStack("gg")
                .commit()
        }

    }
}