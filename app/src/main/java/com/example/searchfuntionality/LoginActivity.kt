package com.example.searchfuntionality

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfuntionality.dto.Result
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private var userData : Result? = null

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
//        getLogin(userName, password)
        if (userName == userData?.email ?: "name" && password == userData?.password ?: "1234" ) {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }
    fun onclickac(view: View) {
        startActivity(Intent(this, SignUp::class.java))
    }

    private fun getLogin(email: String, password: String) {
        val call: Call<Result> = RetrofitClient.getInstance().myApi.getlogin(email, password)
        call.enqueue(object : Callback<Result> {
           override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val user: Result = response.body() as Result
               val gson = Gson()
               val json = gson.toJson(user)
               Log.i(TAG, json)
               userData = Result()
               userData!!.email = user.email
               userData!!.password = user.password
            }


            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}