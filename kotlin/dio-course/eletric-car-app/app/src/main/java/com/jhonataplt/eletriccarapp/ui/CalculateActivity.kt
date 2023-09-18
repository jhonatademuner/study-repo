package com.jhonataplt.eletriccarapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jhonataplt.eletriccarapp.R

class CalculateActivity : AppCompatActivity() {

    lateinit var calculateBtn: Button
    lateinit var resultText: TextView
    lateinit var priceText: EditText
    lateinit var batteryText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        calculateBtn = findViewById(R.id.bt_calculate)
        resultText = findViewById(R.id.tv_result)
        priceText = findViewById(R.id.et_price)
        batteryText = findViewById(R.id.et_battery)

        calculateBtn.setOnClickListener {
            val price = priceText.text.toString().toDouble()
            val battery = batteryText.text.toString().toDouble()
            var result = price / battery
            result = String.format("%.2f", result).toDouble()
            resultText.text = "R$ $result"
        }
    }


}