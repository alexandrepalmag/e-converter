package com.esofthore.e_converter

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double
import java.util.*

class ConverterTemperature : AppCompatActivity() {
    var units = arrayOf("Celsius(C)", "Kelvin(K)", "Fahrenheit(F)")
    var selection = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_temperature)

        //loading components
        val spinner = findViewById<Spinner>(R.id.spinnerComponent)
        val txtResult = findViewById<TextView>(R.id.txtResultFinal)
        val txtValue = findViewById<EditText>(R.id.txtValue)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        //creating Array Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,units)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selection = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        btnConvert.setOnClickListener {
            val valueSent = txtValue.text.toString()

            if (valueSent != "") {
                when (selection) {
                    0 -> {
                        var thisText = " Kelvin = "
                        thisText +=  formatValue(Double.parseDouble(valueSent) + 273.15)
                        thisText += "K \n Fahrenheit = "
                        thisText += formatValue((Double.parseDouble(valueSent) * 9/5)+ 32f)
                        thisText += "°F"
                        txtResult.text = thisText

                    }
                    1 -> {
                        var thisText = " Celsius = "
                        thisText +=  formatValue(Double.parseDouble(valueSent) - 273.15)
                        thisText += "°C \n Fahrenheit = "
                        thisText += formatValue((Double.parseDouble(valueSent) - 273.15)* 9/5 + 32f)
                        thisText += "°F \n"
                        txtResult.text = thisText
                    }
                    2 -> {
                        var thisText = " Celsius = "
                        thisText +=  formatValue((Double.parseDouble(valueSent) - 32) * 5/9 )
                        thisText += "°C \n Kelvin = "
                        thisText += formatValue((Double.parseDouble(valueSent) - 32) * 5/9 + 273.15)
                        thisText += "K"
                        txtResult.text = thisText
                    }
                }
            } else {
                txtResult.text = "Add a value to be converted."
            }//end first if
        }//btnConvert.setOnClickListener

        //active "up navigation"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun formatValue(valor: kotlin.Double): Any? {
        return String.format(Locale.US,"%.2f",valor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}