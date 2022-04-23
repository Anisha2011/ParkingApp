package com.example.searchfuntionality

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.collection.LongSparseArray
import com.example.searchfuntionality.dto.Result
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
    fun onclicksu(view: View) {
        val uname = findViewById<EditText>(R.id.uname).text.toString()
        val unumm = findViewById<EditText>(R.id.unumm).text.toString()
        val ctn = unumm.toLong()
        val uemail = findViewById<EditText>(R.id.uemail).text.toString()
        val upswd = findViewById<EditText>(R.id.upswd).text.toString()
        val upswdd = findViewById<EditText>(R.id.upswdd).text.toString()

        if(upswd != upswdd) {
            Toast.makeText(this, "Password Not Match!", Toast.LENGTH_SHORT).show()
        } else {
            getSignUpP(uname,ctn,uemail,upswd)
        }
        startActivity(Intent(this, Dashboard::class.java))
    }

    private fun getSignUpP(name: String,contact: Long,email: String, password: String) {
        val userData = Result()
        userData.email = email
        userData.password = password
        userData.contact = contact
        userData.name = name

        val call: Call<Result> = RetrofitClient.getInstance().myApi.createPost(userData)
        call.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                Toast.makeText(applicationContext, "SignUP Success", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(applicationContext, "Signup failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}