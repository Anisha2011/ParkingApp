package com.example.searchfuntionality

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.searchfuntionality.dto.Slots
import com.example.searchfuntionality.dto.Walletdto
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Wallet : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "u"

        fun newIntent(context: Context,  user: String): Intent {
            val detailIntent = Intent(context, Parking::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)


        val selectedId = intent.extras?.getString(Parking.EXTRA_USER)
        var userId= selectedId?.toInt()
        if (userId != null) {
            val gson = Gson()
            val json = gson.toJson(userId)
            Log.i(ContentValues.TAG, json)
            getwallet(userId)
        }
    }
    private fun getwallet(userId: Int) {
            val call: Call<Walletdto> = RetrofitClient.getInstance().myApi.getwallet(userId)
        call.enqueue(object : Callback<Walletdto> {
            override fun onResponse(call: Call<Walletdto>, response: Response<Walletdto>) {
                if (response.body() == null) return
                var wallet = response.body() as Walletdto
                var textView = findViewById<TextView>(R.id.balance)
                textView.text = wallet.balance.toString()
            }
            override fun onFailure(call: Call<Walletdto>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}