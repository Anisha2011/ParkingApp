package com.example.searchfuntionality

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
        getUsers()
        if (userName == userData?.user_email ?: "name" && password == userData?.user_password ?: "1234" ) {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUsers() {
        val call: Call<List<Result>> = RetrofitClient.getInstance().myApi.getusers()
        call.enqueue(object : Callback<List<Result>> {
           override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                val myuserList: List<Result> = response.body() as List<Result>
               val gson = Gson()
               val json = gson.toJson(myuserList[0])
               Log.i(TAG, json)
               userData = Result()
               userData!!.user_email = myuserList[0].user_email
               userData!!.user_password = myuserList[0].user_password
            }


            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}