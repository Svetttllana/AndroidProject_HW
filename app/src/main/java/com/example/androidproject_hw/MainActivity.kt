package com.example.androidproject_hw

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.androidproject_hw.MainActivity2.Companion.createTitleInActivity2
import com.example.androidproject_hw.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //menu
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


//
//        val btn1= findViewById<Button>(R.id.btn1)
//        btn1.setOnClickListener(){
//            startActivity(Intent(this,MainActivity2::class.java))
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.openAct2) {
            startMainActivity2(this, getString(R.string.Text1), getString(R.string.Text2))

        }

        if (item.itemId == R.id.clickSecItm) {
            createTitleInActivity2(this, getString(R.string.title2))
        }


        if (item.itemId == R.id.close) {
            finishAffinity()
        }

        if (item.itemId == R.id.goBack) {
            onBackPressed()


        }


        return super.onOptionsItemSelected(item)
    }

}