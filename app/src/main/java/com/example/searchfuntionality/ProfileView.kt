package com.example.searchfuntionality

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileView : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "u"
        const val EXTRA_USERNAME = "uname"
        const val EXTRA_CONTACT = "ct"

        fun newIntent(context: Context, user: String,username: String,contact: String): Intent {
            val detailIntent = Intent(context, ProfileView::class.java)
            detailIntent.putExtra(EXTRA_USER, user)
            detailIntent.putExtra(EXTRA_USERNAME, username)
            detailIntent.putExtra(EXTRA_CONTACT, contact)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        val selectedId = intent.extras?.getString(ProfileView.EXTRA_USER)
        var textView = findViewById<TextView>(R.id.uid)
        textView.text = selectedId

        val selecteduname = intent.extras?.getString(ProfileView.EXTRA_USERNAME)
        var txtView = findViewById<TextView>(R.id.uname2)
        txtView.text = selecteduname

        val selectedcontact = intent.extras?.getString(ProfileView.EXTRA_CONTACT)
        var txView = findViewById<TextView>(R.id.uct)
        txView.text = selectedcontact

    }



}