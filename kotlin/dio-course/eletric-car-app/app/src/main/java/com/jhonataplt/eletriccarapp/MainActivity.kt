package com.jhonataplt.eletriccarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var calculateBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn = findViewById(R.id.button)

        calculateBtn.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }
    }
}