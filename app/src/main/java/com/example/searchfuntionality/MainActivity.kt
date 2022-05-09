package com.example.searchfuntionality

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfuntionality.dto.Parkingdto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val CUSTOM_PREF_NAME = "User_data"
    lateinit var listView: ListView
    var location: ArrayList<String> = ArrayList()
    var parkingList: List<Parkingdto> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearch: EditText

    companion object {
        const val EXTRA_USER = "u"

        fun newIntent(context: Context, user: String): Intent {
            val detailIntent = Intent(context, MainActivity::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getParking()
        title = "PARK HERE!!!"
        listView = findViewById(R.id.listView)
        etSearch = findViewById(R.id.etSearch)

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
        listView.setOnItemClickListener { parent, view, position, id ->
            val selecteditem = parent.getItemAtPosition(position).toString()
            for (parkingdto in parkingList) {

               if(parkingdto.name == selecteditem ){
                   val userid = intent.extras?.getString(MainActivity.EXTRA_USER)
                   val parkingIntent = userid?.let {
                       Parking.newIntent(context, parkingdto.parking_id.toString(),parkingdto.name,
                           parkingdto.charge.toString(), it
                       )
                   }
                   startActivity(parkingIntent)
               }
            }
        }
    }



    private fun getParking() {
        val call: Call<List<Parkingdto>> = RetrofitClient.getInstance().myApi.getparking()
        call.enqueue(object : Callback<List<Parkingdto>> {
            override fun onResponse(call: Call<List<Parkingdto>>, response: Response<List<Parkingdto>>) {
                parkingList = response.body() as List<Parkingdto>

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

