package com.example.searchfuntionality

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.searchfuntionality.dto.Parkingdto
import com.example.searchfuntionality.dto.Slots
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Parking : AppCompatActivity() {
    lateinit var listView: ListView
    var Slist: ArrayList<String> = ArrayList()
    var slotList: List<Slots> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null

    companion object {
        const val EXTRA_PARKING = "p"
        const val EXTRA_CHARGE = "c"
        const val EXTRA_LOCATION = "loc"
        const val EXTRA_USER = "u"

        fun newIntent(context: Context, location: String, name: String, charge: String, user: String): Intent {
            val detailIntent = Intent(context, Parking::class.java)
            detailIntent.putExtra(EXTRA_LOCATION, location)
            detailIntent.putExtra(EXTRA_PARKING, name)
            detailIntent.putExtra(EXTRA_CHARGE, charge)
            detailIntent.putExtra(EXTRA_USER, user)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking)

        listView = findViewById(R.id.listView)

//        var color = getResources().getColor(R.color.black)
//        listView.setBackgroundColor(color)
//
//        TextView tv = (TextView)view.findViewById(android.R.id.listof_loc)
//        tv.setTextColor(Color.WHITE)


        val selectedlocation = intent.extras?.getString(EXTRA_LOCATION)
        val selectedparking = intent.extras?.getString(EXTRA_PARKING)
        val selectedcharge = intent.extras?.getString(EXTRA_CHARGE)
        val selecteduser = intent.extras?.getString(EXTRA_USER)
        var pId = selectedlocation?.toInt()
        if (pId != null) {
            getParkingslots(pId)
        }

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val s = Slist[position]
            if(selectedparking != null && selectedcharge != null && selecteduser != null){
                val bookingIntent = Booking.newIntent(context,selectedparking, s, selectedcharge, selecteduser,
                    pId.toString())
                startActivity(bookingIntent)
            }
        }
    }


    private fun getParkingslots(parkingId: Int) {
        val call: Call<List<Slots>> = RetrofitClient.getInstance().myApi.getparkingslots(parkingId)
        call.enqueue(object : Callback<List<Slots>> {
            override fun onResponse(call: Call<List<Slots>>, response: Response<List<Slots>>) {
                if(response.body() == null) return
                slotList = response.body() as List<Slots>

                slotList.forEach {
                    Slist.add(it.number)
                }
                writeListView(Slist)
            }
            override fun onFailure(call: Call<List<Slots>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun writeListView(Slist: List<String>) {
        arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, Slist)
        listView.adapter = arrayAdapter
    }
}