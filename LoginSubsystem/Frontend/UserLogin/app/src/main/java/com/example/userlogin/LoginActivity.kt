package com.example.userlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

private lateinit var password: String
private lateinit var userName: String
private lateinit var etUsername: EditText
private lateinit var etPassword: EditText
private lateinit var etButton: Button
private lateinit var tvRegisterLink: TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etLUserName)
        etPassword = findViewById(R.id.etLPassword)
        etButton = findViewById(R.id.btnLogin)
        tvRegisterLink = findViewById<TextView>(R.id.tvRegisterLink) as TextView

        tvRegisterLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        etButton.setOnClickListener {
            login(etUsername, etPassword);
//            Toast.makeText(this, "Welcome: " + userName, Toast.LENGTH_SHORT).show();
        }
    }

    private fun login(etUsername:EditText, etPassword:EditText) {
        val userName: String = etUsername.getText().toString().trim()
        val password: String = etPassword.getText().toString().trim()

        val call: Call<ResponseBody> = RetrofitClient
            .getInstance()
            .api
            .checkUser(User(userName, password))

        if (userName.isEmpty()) {
            etUsername.setError("Username is required")
            etPassword.requestFocus()
            return
        } else if (password.isEmpty()) {
            etUsername.setError("Password is required")
            etPassword.requestFocus()
            return
        }

        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (s == userName) {
                    val intent = Intent(this@LoginActivity,DashboardActivity::class.java)
                    intent.putExtra("Username",s)
                    Toast.makeText(
                        this@LoginActivity,
                        "Successfully login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "User does not exists!", Toast.LENGTH_LONG)
                        .show()
//                    startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                }
            }
            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}