package com.example.searchfuntionality

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class VehicleInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_info)

        val showButton = findViewById<Button>(R.id.submit)

//        val editText = findViewById<EditText>(R.id.vname)
//        val editText  = findViewById<EditText>(R.id.vnum)

        // Setting On Click Listener
        showButton.setOnClickListener {

            // Showing the user input
//            Toast.makeText(this, "submitted", Toast.LENGTH_SHORT).show()
   }
    }
}