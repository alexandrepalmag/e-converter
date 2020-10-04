package com.esofthore.e_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner

class ConverterTemperature : AppCompatActivity() {
    var units = arrayOf("Celsius(C)", "Kelvin(K)", "Fahrenheit(F)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_temperature)

        //loading components
        val spinner = findViewById<Spinner>(R.id.spinnerComponent)

        //creating Array Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,units)
        spinner.adapter = adapter

        //active "up navigation"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}