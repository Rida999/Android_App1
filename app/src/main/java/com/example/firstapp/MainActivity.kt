package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val edt:EditText = findViewById(R.id.kilo_edt)
        val btn:Button = findViewById(R.id.btn)
        val result:TextView= findViewById(R.id.result_text)


        btn.setOnClickListener(){
            try {
                val kilos:Double = edt.text.toString().toDouble()
                result.setText(""+ convertToPounds(kilos)+ " lb")
            }
            catch (e: NumberFormatException){
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun convertToPounds(kilos:Double):Double{
        val pounds = kilos*2.20462

        return pounds
    }
}