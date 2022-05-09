package com.example.searchfuntionality


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfuntionality.dto.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //val loginbtn = findViewById<Button>(R.id.loginbtn)
    }

    override fun onBackPressed() {
        this.moveTaskToBack(true)
    }

    fun onclick(view: View) {
        login(
            findViewById<EditText>(R.id.username).text.toString(),
            findViewById<EditText>(R.id.password).text.toString()
        )
    }

    fun onclickac(view: View) {
        startActivity(Intent(this, SignUp::class.java))
    }


    fun login(userName: String, password: String) {
        getLogin(userName, password)
    }

    private fun getLogin(email: String, password: String) {
        val call: Call<Result> = RetrofitClient.getInstance().myApi.getlogin(email, password)
        call.enqueue(object : Callback<Result> {
           override fun onResponse(call: Call<Result>, response: Response<Result>) {
               if (response.isSuccessful()) {
                   if (response.body() != null) {
                       val user: Result = response.body() as Result
                       val dashboardIntent = Dashboard.newIntent(applicationContext , user.id.toString(),
                           user.name, user.contact.toString())
                       startActivity(dashboardIntent);
                   }
                   else {
                       Toast.makeText(
                           applicationContext,
                           "The username or password is incorrect",
                           Toast.LENGTH_SHORT
                       ).show();
                   }
               }
               else {
                   Toast.makeText(
                       applicationContext,
                       "Error! Please try again!",
                       Toast.LENGTH_SHORT
                   ).show();
               }
           }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}
