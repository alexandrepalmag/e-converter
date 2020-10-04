package com.esofthore.e_converter

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double

class ConverterWeight : AppCompatActivity() {
    var units = arrayOf("milligram(mg)", "centigram(cg)", "gram(g)", "kilogram(Kg)")
    var selection = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_weight)

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
                        var thisText = " Centigram = "
                        thisText +=  Double.parseDouble(valueSent)/ 10f
                        thisText += "cg \n Gram = "
                        thisText += Double.parseDouble(valueSent) / 1000f
                        thisText += "g \n Kilogram = "
                        thisText += Double.parseDouble(valueSent) / 1000000f
                        thisText += "kg"
                        txtResult.text = thisText

                    }
                    1 -> {
                        var thisText = " Milligram = "
                        thisText +=  Double.parseDouble(valueSent)* 10f
                        thisText += "mg \n Gram = "
                        thisText += Double.parseDouble(valueSent) / 100f
                        thisText += "g \n Kilogram = "
                        thisText += Double.parseDouble(valueSent) / 100000f
                        thisText += "kg"
                        txtResult.text = thisText
                    }
                    2 -> {
                        var thisText = " Milligram = "
                        thisText +=  Double.parseDouble(valueSent)* 1000f
                        thisText += "mg \n Centigram = "
                        thisText += Double.parseDouble(valueSent) * 100f
                        thisText += "cg \n Kilogram = "
                        thisText += Double.parseDouble(valueSent) / 1000f
                        thisText += "kg"
                        txtResult.text = thisText
                    }
                    3 -> {
                        var thisText = " Milligram = "
                        thisText +=  Double.parseDouble(valueSent)* 1000000f
                        thisText += "mg \n Centigram = "
                        thisText += Double.parseDouble(valueSent) * 100000f
                        thisText += "cg \n Gram = "
                        thisText += Double.parseDouble(valueSent) * 1000f
                        thisText += "g"
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
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}