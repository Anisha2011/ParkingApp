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
        const val  EXTRA_USERNAME = "uname"
        const val EXTRA_CONTACT = "ct"


        fun newIntent(context: Context, user: String, username:String, contact:String ): Intent {
            val detailIntent = Intent(context, Dashboard::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            detailIntent.putExtra(EXTRA_USERNAME, username)
            detailIntent.putExtra(EXTRA_CONTACT, contact)
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
            val userid = intent.extras?.getString(Dashboard.EXTRA_USER)
            val username = intent.extras?.getString(Dashboard.EXTRA_USERNAME)
            val contact = intent.extras?.getString(Dashboard.EXTRA_CONTACT)

          if (userid != null && username != null && contact != null){
              val profileViewIntent = ProfileView.newIntent(applicationContext , userid,username,contact)
              startActivity(profileViewIntent);
          }
    }
    fun onclickVeh(view: View) {
        startActivity(Intent(this, VehicleInfo::class.java))
    }
    fun onclickWallet(view: View) {
        val UserId = intent.extras?.getString(Dashboard.EXTRA_USER)
            val walletActivityIntent = UserId?.let {Wallet.newIntent(applicationContext , it) }
        startActivity(walletActivityIntent);
    }
}