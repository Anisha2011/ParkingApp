package com.example.searchfuntionality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //val loginbtn = findViewById<Button>(R.id.loginbtn)
    }
    fun onclick(view: View) {
        login(
            findViewById<EditText>(R.id.username).text.toString(),
            findViewById<EditText>(R.id.password).text.toString()
        )
    }

    fun login(userName: String, password: String) {
        if (userName == "name" && password == "1234") {
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}