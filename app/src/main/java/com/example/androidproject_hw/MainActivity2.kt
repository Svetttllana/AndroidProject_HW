package com.example.androidproject_hw

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val ImageView = findViewById<ImageView>(R.id.imgV)
        ImageView.setImageResource(R.drawable.little_dog_image)

        rb1.setOnClickListener {
            if (rb1.isChecked) {

                rb2.isChecked = false
            } else {
                rb1.isChecked = true
            }
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false

            } else {
                rb2.isChecked = true
            }
        }


    }





    companion object {
        fun startActivity2(context: Context) {
            context.startActivity(Intent(context, MainActivity2::class.java))
        }

    }
}