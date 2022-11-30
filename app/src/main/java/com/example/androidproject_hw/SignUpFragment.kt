package com.example.androidproject_hw

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class SignUpFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val login2 = view.findViewById<EditText>(R.id.edTex_login2)
        val password2 = view.findViewById<EditText>(R.id.edTex_password2)
        val btSignIn2 = view.findViewById<Button>(R.id.btnSignIn2)


        btSignIn2.setOnClickListener {


            if (login2.text.toString().isEmpty() && password2.text.toString().isEmpty()) {
                login2.error = getString(R.string.LogCantBeEmpty)
                password2.error = getString(R.string.PassCantBeEmpty)

            } else if (login2.text.toString().isEmpty()) {
                login2.error = getString(R.string.LogCantBeEmpty)
            } else if (password2.text.toString().isEmpty()) {
                password2.error = getString(R.string.PassCantBeEmpty)
            } else {

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.actContainer, MainScreenFragment())
                    .commit()

                val dialog = AlertDialog.Builder(context)
                    .setTitle("Information")
                    .setMessage(getString(R.string.Successfully_registrated))
                    .setCancelable(true)
                    .setPositiveButton("Ok") { dialog, _ ->
                        dialog.cancel()
                    }
                    .setNegativeButton("cancel") { dialog, _ -> dialog.cancel() }
                dialog.show()

            }
        }
    }
}