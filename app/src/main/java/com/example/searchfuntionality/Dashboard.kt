package com.example.searchfuntionality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


    }
    fun onclick(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun onclickProfile(view: View) {
        startActivity(Intent(this, ProfileView::class.java))
    }
    fun onclickVeh(view: View) {
        startActivity(Intent(this, VehicleInfo::class.java))
    }
    fun onclickWallet(view: View) {
        startActivity(Intent(this, Wallet::class.java))
    }
}