package com.example.searchfuntionality

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.searchfuntionality.dto.Slots
import com.example.searchfuntionality.dto.Walletdto
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Wallet : AppCompatActivity() {
    lateinit var textView: TextView

    companion object {
        const val EXTRA_USER = "u"

        fun newIntent(context: Context,  user: String): Intent {
            val detailIntent = Intent(context, Wallet::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        textView = findViewById<TextView>(R.id.balance)

        val selectedId = intent.extras?.getString(Wallet.EXTRA_USER)
        val userId= selectedId?.toInt()
        val gson = Gson()
        val json = gson.toJson(userId)
        Log.i(ContentValues.TAG, json)
        if (userId != null) {
            getwallet(userId)
        }
    }

    private fun getwallet(userId: Int) {
            val call: Call<Walletdto> = RetrofitClient.getInstance().myApi.getwallet(userId)
        call.enqueue(object : Callback<Walletdto> {
            override fun onResponse(call: Call<Walletdto>, response: Response<Walletdto>) {
                //if (response.body() == null) return
                val wallet = response.body() as Walletdto
                val gson = Gson()
                val json = gson.toJson(wallet)
                Log.i(ContentValues.TAG, json)

                textView.text = wallet.balance.toString()
                Toast.makeText(applicationContext, "successfully called", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<Walletdto>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}