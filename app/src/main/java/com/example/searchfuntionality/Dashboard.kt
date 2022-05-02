package com.example.searchfuntionality

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Dashboard : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "u"


        fun newIntent(context: Context, user: String): Intent {
            val detailIntent = Intent(context, Dashboard::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

    }
    fun onclick(view: View) {
        val userid = intent.extras?.getString(Dashboard.EXTRA_USER)
        val mainActivityIntent = userid?.let { MainActivity.newIntent(applicationContext , it) }
        startActivity(mainActivityIntent);
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