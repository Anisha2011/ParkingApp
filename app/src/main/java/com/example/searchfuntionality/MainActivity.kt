package com.example.searchfuntionality

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    var location: ArrayList<String> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearch: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "PARK HERE!!!"
        listView = findViewById(R.id.listView)
        etSearch = findViewById(R.id.etSearch)
        location.add("Aundh")
        location.add("Balaji Nagar")
        location.add("Sadashiv Peth")
        location.add("kothrud")
        location.add("Karvenagar")
        location.add("Ambegaon")
       location.add("Swargate")
        location.add("Katraj")
       location.add("Kondhwa")
       location.add("ABC Chowk")
       location.add("Bibwewadi")
        location.add("Tilak Rd")
        location.add("Sarasbaugh")
        location.add("laxmi road")

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
}
