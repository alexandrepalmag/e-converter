package com.esofthore.e_converter

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double

class ConverterData : AppCompatActivity() {
    var units = arrayOf("byte(b)", "kilobyte(kb)", "megabyte(mb)", "gigabyte(gb)")
    var selection = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_datas)

        //loading components
        val spinner = findViewById<Spinner>(R.id.spinnerComponent)
        val txtResult = findViewById<TextView>(R.id.txtResultFinal)
        val txtValue = findViewById<EditText>(R.id.txtValue)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        //creating Array Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, units)
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
                        var thisText = " Kilobyte = "
                        thisText +=  Double.parseDouble(valueSent)/ 1000f
                        thisText += "kb \n MegaByte = "
                        thisText += Double.parseDouble(valueSent) / 1000000f
                        thisText += "mb \n Gigabyte = "
                        thisText += Double.parseDouble(valueSent) / 1000000000f
                        thisText += "gb"
                        txtResult.text = thisText

                    }
                    1 -> {
                        var thisText = " Byte = "
                        thisText +=  Double.parseDouble(valueSent)* 1000f
                        thisText += "b \n MegaByte = "
                        thisText += Double.parseDouble(valueSent) / 1000f
                        thisText += "mb \n GigaByte = "
                        thisText += Double.parseDouble(valueSent) / 1000000f
                        thisText += "gb"
                        txtResult.text = thisText
                    }
                    2 -> {
                        var thisText = " Byte = "
                        thisText +=  Double.parseDouble(valueSent)* 1000000f
                        thisText += "b \n KiloByte = "
                        thisText += Double.parseDouble(valueSent) * 1000f
                        thisText += "kb \n GigaByte = "
                        thisText += Double.parseDouble(valueSent) / 1000f
                        thisText += "gb"
                        txtResult.text = thisText
                    }
                    3 -> {
                        var thisText = " Byte = "
                        thisText +=  Double.parseDouble(valueSent)* 1000000000f
                        thisText += "b \n KiloByte = "
                        thisText += Double.parseDouble(valueSent) * 1000000f
                        thisText += "kb \n MegaByte = "
                        thisText += Double.parseDouble(valueSent) * 1000f
                        thisText += "mb"
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}