package com.example.searchfuntionality

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class Parking : AppCompatActivity() {
    lateinit var listView: ListView
    var hashMap: HashMap<String, ArrayList<String>> =
        HashMap<String, ArrayList<String>>() //define empty hashmap


    companion object {
        const val EXTRA_LOCATION = "loc"

        fun newIntent(context: Context, location: String): Intent {
            val detailIntent = Intent(context, Parking::class.java)
            detailIntent.putExtra(EXTRA_LOCATION, location)
            return detailIntent
        }
    }

    var location = arrayListOf<String>()
    var arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking)
        hashMap.put("Katraj", arrayListOf("P1", "P2"))
        listView = findViewById(R.id.listView)
        val selectedlocation = intent.extras?.getString(EXTRA_LOCATION)
        val parkingList = hashMap.get(selectedlocation)
        if (parkingList != null) {
            location = parkingList
        }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1,location)
        listView.adapter = arrayAdapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val selectedLocation = location[position]

            // 2
            val bookingIntent = Booking.newIntent(context, selectedLocation)

            // 3
            startActivity(bookingIntent)
        }

    }
}