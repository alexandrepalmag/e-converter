package com.esofthore.e_converter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loading components
        val btnLength = findViewById<ImageButton>(R.id.btnLength)
        btnLength.setOnClickListener {
            val intent = Intent(this, ConverterLength::class.java)
            startActivity(intent)
        }
    }
}