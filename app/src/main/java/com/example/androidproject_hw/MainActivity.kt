package com.example.androidproject_hw

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.androidproject_hw.MainActivity2.Companion.startActivity2
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Et_login = findViewById<EditText>(R.id.etLogin)
        val Et_password = findViewById<EditText>(R.id.etPassword)
        val btn_Sign = findViewById<Button>(R.id.btnSign)

        val layoutLog = findViewById<TextInputLayout>(R.id.layoutLogin)
        val layoutPassword = findViewById<TextInputLayout>(R.id.layoutPassword)

        btn_Sign.setOnClickListener {

            if (Et_login.text.toString().isEmpty() && Et_password.text.toString().isEmpty()) {
                layoutLog.error = getString(R.string.login_cant_be_empty)
                layoutPassword.error = getString(R.string.password_cant_be_empty)

            } else if (Et_login.text.toString().isEmpty()) {


                layoutLog.error = getString(R.string.login_cant_be_empty)


            } else if (Et_password.text.toString().isEmpty()) {
                layoutPassword.error = getString(R.string.password_cant_be_empty)
            } else {
                startActivity2(this)
            }
        }
    }
}


