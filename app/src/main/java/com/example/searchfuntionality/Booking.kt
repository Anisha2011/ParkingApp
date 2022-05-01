package com.example.searchfuntionality

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.searchfuntionality.dto.Bookingdto
import com.example.searchfuntionality.dto.Parkingdto
import com.example.searchfuntionality.dto.Slots
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Booking : AppCompatActivity()
{
    companion object {
        const val EXTRA_PARKING = "loc"
        const val EXTRA_SLOT = "s"
        const val EXTRA_CHARGE = "c"

        fun newIntent(context: Context, parking: String,slot : String , charge : String): Intent {
            val detailIntent = Intent(context, Booking::class.java)
            detailIntent.putExtra(EXTRA_PARKING, parking)
            detailIntent.putExtra(EXTRA_SLOT, slot)
            detailIntent.putExtra(EXTRA_CHARGE, charge)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking2)
        val selectedslot = intent.extras?.getString(Booking.EXTRA_SLOT)
        val selectedparking = intent.extras?.getString(Booking.EXTRA_PARKING)
        val selectedcharge = intent.extras?.getString(Booking.EXTRA_CHARGE)

        val showButton = findViewById<Button>(R.id.okbtn)
        val slotText = findViewById<TextView>(R.id.slotId)
        val parkingName = findViewById<TextView>(R.id.pname)
        val pay = findViewById<TextView>(R.id.pcost)

        slotText.text = selectedslot
        parkingName.text = selectedparking
        pay.text = selectedcharge


        showButton.setOnClickListener {
//            val bookingdto : Bookingdto = Bookingdto(
//
//            )
//            confirmBooking()

        }
    }
    private fun confirmBooking(bookingdto: Bookingdto) {
       val call: Call<String> = RetrofitClient.getInstance().myApi.confirmBooking(bookingdto)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.body() == null) return
                val res  = response.body() as String
                Toast.makeText(applicationContext, "Booking Successful", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}




