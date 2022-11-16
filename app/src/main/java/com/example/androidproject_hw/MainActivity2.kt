package com.example.androidproject_hw

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.System.getString
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val frstTxtView = findViewById<TextView>(R.id.textView)
        val first = intent.getStringExtra(A)


        frstTxtView.text = first


        val secTxtView = findViewById<TextView>(R.id.textView2)
        val second = intent.getStringExtra(B)


        secTxtView.text = second


        val title = intent.getStringExtra(C)
        supportActionBar?.title = title

    }


    companion object {
        private const val A = "a"
        private const val B = "b"
        private const val C = "c"


        fun startMainActivity2(context: Context, string: String, string2: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(A, string)
            intent.putExtra(B, string2)
            context.startActivity(intent)

        }

        fun createTitleInActivity2(context: Context, string3: String) {
            val intent1 = Intent(context, MainActivity2::class.java)
            intent1.putExtra(C, string3)
            context.startActivity(intent1)

        }


    }

}