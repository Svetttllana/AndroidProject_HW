package com.example.androidproject_hw

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.finishAffinity

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val btnCoToActivity4=findViewById<Button>(R.id.btnGoToActivity4)
btnCoToActivity4.setOnClickListener{
    startActivity(
        Intent(this,MainActivity4::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    )
}
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}


