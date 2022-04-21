package com.example.searchfuntionality

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Booking : AppCompatActivity()
{
    companion object {
        const val EXTRA_PARKING = "loc"

        fun newIntent(context: Context, parking: String): Intent {
            val detailIntent = Intent(context, Booking::class.java)
            detailIntent.putExtra(EXTRA_PARKING, parking)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking2)
        val selectedparking = intent.extras?.getString(Booking.EXTRA_PARKING)

        val showButton = findViewById<Button>(R.id.okbtn)
        val slotText = findViewById<TextView>(R.id.slotId)
        val parkingName = findViewById<TextView>(R.id.pname)
        val pay = findViewById<TextView>(R.id.pcost)

        slotText.text = "slot-1"
        parkingName.text = selectedparking
        pay.text = "250"



        showButton.setOnClickListener {
            Toast.makeText(this, "Booking Successful", Toast.LENGTH_SHORT).show()
        }
    }
}




