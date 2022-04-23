package com.example.searchfuntionality

import android.content.ContentValues
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfuntionality.dto.Parkingdto
import com.example.searchfuntionality.dto.Result
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    var location: ArrayList<String> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearch: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           getParking()
        Log.i(ContentValues.TAG, location.size.toString())
        title = "PARK HERE!!!"
        listView = findViewById(R.id.listView)
        etSearch = findViewById(R.id.etSearch)
//        location.add("Aundh")
//        location.add("Balaji Nagar")
//        location.add("Sadashiv Peth")
//        location.add("kothrud")
//        location.add("Karvenagar")
//        location.add("Ambegaon")
//       location.add("Swargate")
//        location.add("Katraj")
//       location.add("Kondhwa")
//       location.add("ABC Chowk")
//       location.add("Bibwewadi")
//        location.add("Tilak Rd")
//        location.add("Sarasbaugh")
//        location.add("Laxmi road")

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1,location)
        listView.adapter = arrayAdapter
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                arrayAdapter!!.filter.filter(s)

            }
            override fun afterTextChanged(s: Editable) {}
        })
        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val selectedLocation = location[position]

            // 2
            val parkingIntent = Parking.newIntent(context, selectedLocation)

            // 3
            startActivity(parkingIntent)
        }

    }
    private fun getParking() {
        val call: Call<List<Parkingdto>> = RetrofitClient.getInstance().myApi.getparking()
        call.enqueue(object : Callback<List<Parkingdto>> {
            override fun onResponse(call: Call<List<Parkingdto>>, response: Response<List<Parkingdto>>) {
                val parkingList: List<Parkingdto> = response.body() as List<Parkingdto>

                parkingList.forEach {
                    location.add(it.name)
                }
            }

            override fun onFailure(call: Call<List<Parkingdto>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}
