package com.example.androidproject_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val login = findViewById<EditText>(R.id.edTex_login)
val password = findViewById<EditText>(R.id.edTex_password)
val btDisplayText = findViewById<Button>(R.id.bt_displayText)
val TextView = findViewById<TextView>(R.id.textView)
        val layoutLog = findViewById<TextInputLayout>(R.id.layout_login)
        val layoutPassword = findViewById<TextInputLayout>(R.id.layout_password)

        btDisplayText.setOnClickListener{
        //    dialog.show()
          if (login.text.toString().isEmpty()){
              login.error = getString(R.string.LogCantBeEmpty)
          }else if (password.text.toString().isEmpty()){
              password.error = getString(R.string.PassCantBeEmpty)
          }else{
              TextView.text = "${login.text.toString()} ${password.text.toString()}"


              val dialog =AlertDialog.Builder(this)
                  .setTitle("Information")
                  .setMessage("Login:" + "${login.text.toString()} " + "Password:" +"\n ${password.text.toString()}")
                  .setCancelable(true)
                  .setPositiveButton("Ok") { dialog, _ ->
                      dialog.cancel()}
                  .setNegativeButton("cancel") {dialog, _ -> dialog.cancel()}
              dialog.show()


          }
        }

//        val dialog =AlertDialog.Builder(this)
//            .setTitle("Information")
//            .setMessage("Login:" + "${login.text.toString()} " + "Password:" +"\n ${password.text.toString()}")
//            .setCancelable(true)
//            .setPositiveButton("Ok") { dialog, _ ->
//                dialog.cancel()}
//            .setNegativeButton("cancel") {dialog, _ -> dialog.cancel()}
//        dialog.show()


    }
}