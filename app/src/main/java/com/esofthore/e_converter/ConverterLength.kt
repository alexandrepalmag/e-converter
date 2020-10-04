package com.esofthore.e_converter

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double

class ConverterLength : AppCompatActivity() {
    var units = arrayOf("millimeter(mm)", "centimeter(cm)", "meter(m)", "kilometer(km)")
    var selection = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_length)

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
                if (selection == 0) {
                    var thisText = "Centimeter = "
                    thisText += Double.parseDouble(valueSent) / 10f
                    thisText += "cm \nMeter = "
                    thisText += Double.parseDouble(valueSent) / 1000f
                    thisText += "m \nKilometer = "
                    thisText += Double.parseDouble(valueSent) / 1000000f
                    thisText += "km"
                    txtResult.text = thisText

                }else if(selection == 1) {
                    var thisText = "Millimeter = "
                    thisText += Double.parseDouble(valueSent) * 10f
                    thisText += "cm \nMeter = "
                    thisText += Double.parseDouble(valueSent) / 100f
                    thisText += "m \nKilometer = "
                    thisText += Double.parseDouble(valueSent) / 100000f
                    thisText += "km"
                    txtResult.text = thisText
                }else if(selection == 2){
                    var thisText = "Millimeter = "
                    thisText += Double.parseDouble(valueSent) * 1000f
                    thisText += "cm \nCentimeter = "
                    thisText += Double.parseDouble(valueSent) * 100f
                    thisText += "m \nKilometer = "
                    thisText += Double.parseDouble(valueSent) / 1000f
                    thisText += "km"
                    txtResult.text = thisText
                }else if(selection == 3) {
                    var thisText = "Millimeter = "
                    thisText += Double.parseDouble(valueSent) * 100000f
                    thisText += "cm \nCentimeter = "
                    thisText += Double.parseDouble(valueSent) * 100000f
                    thisText += "m \nMeter = "
                    thisText += Double.parseDouble(valueSent) * 1000f
                    thisText += "m"
                    txtResult.text = thisText
                }else{
                    txtResult.text = "Add a value to be converted."
                }
            }//end first if
        }//btnConvert.setOnClickListener

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
